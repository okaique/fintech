package br.com.fintech.fintechfiap;

import dao.ReceitaDAO;
import dao.ContaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import transaction.Receita;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/CadastrarReceitaServlet")
public class CadastrarReceitaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não autorizado.");
            return;
        }

        try {
            String nomeReceita = request.getParameter("nomeReceita");
            String descricao = request.getParameter("descricao");
            double valor = Double.parseDouble(request.getParameter("valor"));

            if (nomeReceita == null || nomeReceita.isEmpty() || descricao == null || descricao.isEmpty() || valor <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parâmetros inválidos.");
                return;
            }

            Integer cdConta = (Integer) session.getAttribute("cdConta");
            if (cdConta == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Conta não encontrada.");
                return;
            }

            Receita receita = new Receita(0, valor, descricao, cdConta, Date.valueOf(LocalDate.now()), LocalTime.now().toString().substring(0, 5), nomeReceita);
            ReceitaDAO receitaDAO = new ReceitaDAO();
            receitaDAO.insert(receita);

            ContaDAO contaDAO = new ContaDAO();
            contaDAO.atualizarSaldo(cdConta, valor);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Receita cadastrada com sucesso!");

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao cadastrar receita.");
        }
    }
}
