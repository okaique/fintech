<%@ page import="model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Usuário Logado</title>
</head>
<body>

<h2>Bem-vindo!</h2>

<%
    // Obtendo o usuário logado da sessão
    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

    if (usuarioLogado != null) {
%>
<div>
    <h3>Usuário logado:</h3>
    <p><strong>Nome:</strong> <%= usuarioLogado.getNome() %></p>
    <p><strong>Email:</strong> <%= usuarioLogado.getEmail() %></p>
</div>
<%
} else {
%>
<div>
    <p>Você não está logado. <a href="index.jsp">Clique aqui para fazer login</a></p>
</div>
<%
    }
%>

<a href="index.jsp">Voltar para o login</a>

</body>
</html>