package br.com.fintech.fintechfiap;

import dao.ContaDAO;
import model.Conta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CadastrarContaServlet")
public class CadastrarContaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoConta = request.getParameter("tipoConta");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
        String nomeBanco = request.getParameter("nomeBanco");

        Conta conta = new Conta(0, tipoConta, saldo, cdUsuario, nomeBanco);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);

        // Adiciona a nova conta na sessão para exibição imediata
        HttpSession session = request.getSession();
        session.setAttribute("novaConta", conta);

        response.sendRedirect("loginSucess");
    }
}
