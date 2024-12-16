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

@WebServlet("/loginTeste")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioLogado = usuarioDAO.getByEmailAndSenha(email, senha);

        if (usuarioLogado != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuarioLogado);
            response.sendRedirect("loginSucess");  // Redireciona para o servlet de sucesso de login
        } else {
            response.sendRedirect("index.jsp?erro=true");
        }
    }
}
