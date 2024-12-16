document.addEventListener("DOMContentLoaded", function () {
    const toggleButtons = document.querySelectorAll('.togglePassword');
    if (toggleButtons.length > 0) {
        toggleButtons.forEach(button => {
            button.addEventListener('click', (event) => {
                const passwordInput = event.target.previousElementSibling;
                if (passwordInput && passwordInput.type) {
                    passwordInput.type = passwordInput.type === 'password' ? 'text' : 'password';
                }
            });
        });
    }
});
