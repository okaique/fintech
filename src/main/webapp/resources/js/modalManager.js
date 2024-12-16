document.addEventListener("DOMContentLoaded", function () {
    // Função para abrir um modal dinâmico a partir de um arquivo HTML
    function openModal(modalUrl) {
        fetch(modalUrl)
            .then(response => response.text())
            .then(html => {
                const modalContainer = document.getElementById("modalContainer");
                modalContainer.innerHTML = html;

                const modal = modalContainer.querySelector(".modal");
                if (modal) {
                    // Exibe o modal
                    modalContainer.style.opacity = "1";
                    modalContainer.style.zIndex = "99";

                    // Evento para fechar o modal ao clicar no botão de fechar
                    const closeModalBtn = modal.querySelector(".closeModalBtn");
                    if (closeModalBtn) {
                        closeModalBtn.addEventListener("click", function () {
                            // Oculta o modal e remove seu conteúdo
                            modalContainer.style.opacity = "0";
                            modalContainer.style.zIndex = "-10";
                            modalContainer.innerHTML = ""; // Remove o modal do HTML
                        });
                    }

                    // Evento de envio no formulário dentro do modal
                    const form = modal.querySelector("form");
                    if (form) {
                        form.addEventListener("submit", function (event) {
                            event.preventDefault();
                            handleFormSubmit(form);
                        });
                    }
                }
            })
            .catch(error => console.error("Erro ao carregar o modal:", error));
    }

    // Evento para abrir o modal ao clicar em um botão com data-modal-url
    document.querySelectorAll("[data-modal-url]").forEach(button => {
        button.addEventListener("click", function () {
            const modalUrl = button.getAttribute("data-modal-url");
            openModal(modalUrl);
        });
    });
});
