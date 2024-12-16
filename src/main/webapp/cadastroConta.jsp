<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech - Cadastro de Conta</title>
    <link rel="stylesheet" href="resources/css/output.css">
</head>
<body>
<div class="layoutContainer">
    <main class="layoutMain">
        <div class="layoutBody">
            <div class="formContainer">
                <div class="formContentBox formContent">
                    <div class="formInfo">
                        <h2>Cadastro de Conta</h2>
                    </div>
                    <div class="form">
                        <form action="CadastrarContaServlet" method="POST">
                            <div class="inputContainer">
                                <label for="tipoConta">Tipo de Conta:</label>
                                <input type="text" id="tipoConta" name="tipoConta" required tabindex="1">
                            </div>
                            <div class="inputContainer">
                                <label for="saldo">Saldo Inicial:</label>
                                <input type="number" id="saldo" name="saldo" required tabindex="2">
                            </div>
                            <div class="inputContainer">
                                <label for="nomeBanco">Nome do Banco:</label>
                                <input type="text" id="nomeBanco" name="nomeBanco" required tabindex="3">
                            </div>
                            <input type="hidden" name="cdUsuario" value="${param.cdUsuario}">

                            <button type="submit" class="submitBtn" tabindex="4">Cadastrar Conta</button>
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
</body>
</html>
