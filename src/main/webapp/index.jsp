<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // Usar a vari�vel session impl�cita do JSP
    if (session != null && session.getAttribute("usuarioLogado") != null) {
        response.sendRedirect("dashboard.jsp"); // Redireciona para a p�gina de sucesso
        return; // Impede que o restante da p�gina seja carregado
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech - Login</title>
    <link rel="stylesheet" href="resources/css/output.css">
</head>
<body>
<div class="layoutContainer">
    <main class="layoutMain">
        <div class="layoutBody">
            <div class="formContainer">
                <div class="formContentBox formContent">
                    <div class="formInfo">
                        <h2>Login</h2>
                        <p>Seja bem-vindo de volta!<br>Sentimos a sua falta</p>
                    </div>
                    <div class="form">
                        <form action="LoginTeste" method="POST">
                            <div class="inputContainer">
                                <label for="email">Email</label>
                                <input type="email" id="email" name="email" placeholder="Digite o seu e-mail" required tabindex="1">
                            </div>
                            <div class="inputContainer">
                                <label for="senha">Senha</label>
                                <div class="passwordContainer">
                                    <input type="password" id="senha" name="senha" placeholder="Digite a sua senha" required tabindex="2">
                                    <button type="button" class="togglePassword" tabindex="3">
                                        <img src="resources/assets/img/eye.png">
                                    </button>
                                </div>
                                <a href="#" class="forgotPassword" tabindex="4">Esqueci minha senha</a>
                            </div>
                            <button type="submit" class="submitBtn" tabindex="5">Entrar</button>
                            <a href="cadastroUsuario.jsp" class="registerLink" tabindex="6">Ainda não possui conta?<span style="color: var(--primary-color);">Faça o seu cadastro!</span></a>
                        </form>
                    </div>
                </div>
                <div class="formContentBox formImage">
                    <div class="formImage">
                        <img src="resources/assets/svg/loginImage.svg" alt="Relatorios Vetor">
                    </div>
                    <div class="formInfo">
                        <h3>Lorem ipsum dolor sit</h3>
                        <p>Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<script src="resources/js/forms.js"></script>
</body>
</html>
