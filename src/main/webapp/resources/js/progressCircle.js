document.addEventListener("DOMContentLoaded", function () {
    const transactionHistoryElement = document.querySelector(".transactionHistory");
    const receitasTotais = parseFloat(transactionHistoryElement.getAttribute("data-receitas-totais"));
    const despesasTotais = parseFloat(transactionHistoryElement.getAttribute("data-despesas-totais"));

    const total = receitasTotais + despesasTotais;

    if (total > 0) {
        const percentage = (receitasTotais / total) * 100;
        const strokeDasharray = 351.86; // Circunferência completa do círculo
        const dashOffset = strokeDasharray * (1 - percentage / 100);

        // Aplica o dashoffset ao círculo para animar o progresso
        document.getElementById('progressCircle').style.strokeDashoffset = dashOffset;
    }
});
