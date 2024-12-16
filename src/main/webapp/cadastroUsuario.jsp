<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech - Cadastro</title>
    <link rel="stylesheet" href="resources/css/output.css">
</head>
<body>
<div class="layoutContainer">
    <main class="layoutMain">
        <div class="layoutBody">
            <div class="formContainer">
                <div class="formContentBox formContent">
                    <div class="formInfo">
                        <h2>Cadastro</h2>
                    </div>
                    <div class="form">
                        <form action="CadastrarUsuarioServlet" method="POST">
                            <div class="inputContainer">
                                <label for="nome">Nome:</label>
                                <input type="text" id="nome" name="nome" required tabindex="1">
                            </div>
                            <div class="inputContainer">
                                <label for="sobrenome">Sobrenome:</label>
                                <input type="text" id="sobrenome" name="sobrenome" required tabindex="2">
                            </div>
                            <div class="inputContainer">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" required tabindex="3">
                            </div>

                            <!-- Campo de senha com validação de requisitos -->
                            <div class="inputContainer">
                                <label for="senha">Senha</label>
                                <div class="passwordContainer">
                                    <input type="password" id="senha" name="senha" placeholder="Digite a sua senha" required tabindex="4">
                                    <button type="button" class="togglePassword" tabindex="5">
                                        <img src="resources/assets/img/eye.png">
                                    </button>
                                </div>
                                <ul id="senhaRequisitos" class="senhaRequisitos">
                                    <li id="minLength" class="invalid">Mínimo de 8 caracteres</li>
                                    <li id="specialChar" class="invalid">01 Caractere especial</li>
                                    <li id="uppercase" class="invalid">01 Letra maiúscula</li>
                                </ul>
                            </div>

                            <!-- Campo de confirmação de senha -->
                            <div class="inputContainer">
                                <label for="confirmaSenha">Confirmar Senha</label>
                                <input type="password" id="confirmaSenha" name="confirmaSenha" placeholder="Confirme sua senha" required tabindex="6">
                                <span id="senhaMismatch" class="senhaMismatch" style="display: none;">As senhas não coincidem</span>
                            </div>

                            <button type="submit" class="submitBtn" id="submitBtn" disabled tabindex="7">Cadastrar</button>
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
<script src="resources/js/cadastroValidacao.js"></script>
<script src="resources/js/forms.js"></script>
</body>
</html>
