package br.com.fintech.fintechfiap;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Obtém a sessão existente (não cria uma nova)
        if (session != null) {
            session.invalidate(); // Invalida a sessão, efetivamente "deslogando" o usuário
        }
        response.sendRedirect("index.jsp"); // Redireciona para a página de login
    }
}
