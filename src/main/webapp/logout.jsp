<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // A variável session já é implícita no JSP, então não precisa ser declarada novamente
    if (session != null) {
        // Invalidando a sessão para "deslogar" o usuário
        session.invalidate();
    }

    // Redireciona para a página de login após o logout
    response.sendRedirect("index.jsp");
%>
