document.addEventListener("DOMContentLoaded", function () {
    const senhaInput = document.getElementById("senha");
    const confirmaSenhaInput = document.getElementById("confirmaSenha");
    const senhaMismatchMessage = document.getElementById("senhaMismatch");
    const submitBtn = document.getElementById("submitBtn");

    // Requisitos de senha
    const minLength = document.getElementById("minLength");
    const specialChar = document.getElementById("specialChar");
    const uppercase = document.getElementById("uppercase");

    function validateForm() {
        const senha = senhaInput.value;
        const isMinLengthValid = senha.length >= 8;
        const isSpecialCharValid = /[!@#$%^&*(),.?":{}|<>]/.test(senha);
        const isUppercaseValid = /[A-Z]/.test(senha);
        const isPasswordMatch = senha === confirmaSenhaInput.value;

        // Atualiza o estado do botão de submissão
        submitBtn.disabled = !(isMinLengthValid && isSpecialCharValid && isUppercaseValid && isPasswordMatch);
    }

    // Função para validar os requisitos da senha
    senhaInput.addEventListener("input", function () {
        const senha = senhaInput.value;

        // Verifica o comprimento mínimo
        if (senha.length >= 8) {
            minLength.classList.add("valid");
            minLength.classList.remove("invalid");
        } else {
            minLength.classList.add("invalid");
            minLength.classList.remove("valid");
        }

        // Verifica o caractere especial
        if (/[!@#$%^&*(),.?":{}|<>]/.test(senha)) {
            specialChar.classList.add("valid");
            specialChar.classList.remove("invalid");
        } else {
            specialChar.classList.add("invalid");
            specialChar.classList.remove("valid");
        }

        // Verifica a letra maiúscula
        if (/[A-Z]/.test(senha)) {
            uppercase.classList.add("valid");
            uppercase.classList.remove("invalid");
        } else {
            uppercase.classList.add("invalid");
            uppercase.classList.remove("valid");
        }

        validateForm();
    });

    // Função para verificar se as senhas coincidem
    confirmaSenhaInput.addEventListener("input", function () {
        if (confirmaSenhaInput.value !== senhaInput.value) {
            senhaMismatchMessage.style.display = "block";
        } else {
            senhaMismatchMessage.style.display = "none";
        }
        validateForm();
    });
});