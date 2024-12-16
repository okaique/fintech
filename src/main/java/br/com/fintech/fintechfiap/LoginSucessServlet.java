package br.com.fintech.fintechfiap;

import dao.ContaDAO;
import dao.ReceitaDAO;
import dao.DespesaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.Conta;
import transaction.Receita;
import transaction.Despesa;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@WebServlet("/loginSucess")
public class LoginSucessServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        ContaDAO contaDAO = new ContaDAO();
        ReceitaDAO receitaDAO = new ReceitaDAO();
        DespesaDAO despesaDAO = new DespesaDAO();

        int cdUsuario = usuarioLogado.getCdUsuario();
        List<Conta> contas = contaDAO.getContasPorUsuario(cdUsuario);

        // Armazena o primeiro cdConta na sessão, se houver contas
        if (!contas.isEmpty()) {
            session.setAttribute("cdConta", contas.get(0).getCdConta());
        }

        Map<Integer, List<Receita>> receitasPorConta = new HashMap<>();
        Map<Integer, List<Despesa>> despesasPorConta = new HashMap<>();
        Map<Integer, Double> totaisReceitas = new HashMap<>();
        Map<Integer, Double> totaisDespesas = new HashMap<>();

        for (Conta conta : contas) {
            int cdConta = conta.getCdConta();

            List<Receita> receitas = receitaDAO.getReceitasPorConta(cdConta);
            List<Despesa> despesas = despesaDAO.getDespesasPorConta(cdConta);

            receitasPorConta.put(cdConta, receitas);
            despesasPorConta.put(cdConta, despesas);

            double totalReceitas = receitas.stream().mapToDouble(Receita::getValor).sum();
            double totalDespesas = despesas.stream().mapToDouble(Despesa::getValor).sum();

            totaisReceitas.put(cdConta, totalReceitas);
            totaisDespesas.put(cdConta, totalDespesas);
        }

        // Passa as informações para o JSP
        request.setAttribute("usuario", usuarioLogado);
        request.setAttribute("contas", contas);
        request.setAttribute("receitasPorConta", receitasPorConta);
        request.setAttribute("despesasPorConta", despesasPorConta);
        request.setAttribute("totaisReceitas", totaisReceitas);
        request.setAttribute("totaisDespesas", totaisDespesas);

        request.getRequestDispatcher("loginSucess.jsp").forward(request, response);
    }
}
