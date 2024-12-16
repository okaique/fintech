// ajaxRequest.js
function handleFormSubmit(form) {
    const formData = new FormData(form);
    const params = new URLSearchParams(formData);

    fetch(form.action, {
        method: form.method,
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: params.toString()
    })
        .then(response => {
            if (response.ok) {
                alert("Operação realizada com sucesso!");

                // Oculta o modal e remove seu conteúdo
                const modalContainer = document.getElementById("modalContainer");
                modalContainer.style.opacity = "0";
                modalContainer.style.zIndex = "-10";
                modalContainer.innerHTML = ""; // Remove o modal do HTML

                // Recarrega a página
                location.reload();
            } else {
                alert("Erro ao processar a requisição.");
            }
        })
        .catch(error => {
            console.error("Erro:", error);
            alert("Erro ao processar a requisição.");
        });
}
