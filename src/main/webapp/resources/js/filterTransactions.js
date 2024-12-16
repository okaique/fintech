function filterTransactions(type) {
    const rows = document.querySelectorAll('.transactionRow');
    rows.forEach(row => {
        if (type === 'all') {
            row.style.display = '';
        } else {
            row.style.display = row.classList.contains(type) ? '' : 'none';
        }
    });
}

let sortDirections = [true, true, true, true, true]; // Controle de direção de ordenação para cada coluna

function sortTable(columnIndex) {
    const table = document.querySelector(".transactionTable tbody");
    const rows = Array.from(table.querySelectorAll("tr"));
    const isAscending = sortDirections[columnIndex];

    rows.sort((a, b) => {
        const aText = a.children[columnIndex].innerText.trim();
        const bText = b.children[columnIndex].innerText.trim();

        if (columnIndex === 2) { // Ordenação por valor numérico
            return isAscending ?
                aText.replace('R$ ', '') - bText.replace('R$ ', '') :
                bText.replace('R$ ', '') - aText.replace('R$ ', '');
        } else if (columnIndex === 3 || columnIndex === 4) { // Ordenação por data e hora combinados
            const aDateTime = new Date(`${a.children[3].innerText.trim()} ${a.children[4].innerText.trim()}`);
            const bDateTime = new Date(`${b.children[3].innerText.trim()} ${b.children[4].innerText.trim()}`);
            return isAscending ? aDateTime - bDateTime : bDateTime - aDateTime;
        } else { // Ordenação por texto
            return isAscending ? aText.localeCompare(bText) : bText.localeCompare(aText);
        }
    });

    sortDirections[columnIndex] = !isAscending;
    table.innerHTML = "";
    rows.forEach(row => table.appendChild(row));
}

function sortByDateAndTime() {
    const table = document.querySelector(".transactionTable tbody");
    const rows = Array.from(table.querySelectorAll("tr"));

    rows.sort((a, b) => {
        const aDateTime = new Date(`${a.children[3].innerText.trim()} ${a.children[4].innerText.trim()}`);
        const bDateTime = new Date(`${b.children[3].innerText.trim()} ${b.children[4].innerText.trim()}`);
        return bDateTime - aDateTime; // Ordenação decrescente (mais recente primeiro)
    });

    table.innerHTML = "";
    rows.forEach(row => table.appendChild(row));
}

// Chama a função para ordenar por data e hora ao carregar a página
document.addEventListener("DOMContentLoaded", sortByDateAndTime);
