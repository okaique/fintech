document.addEventListener('DOMContentLoaded', function () {
    var ctx = document.querySelector('.myChart');
    ctx.style.height = '100%'; // Define a altura manualmente
    ctx.style.minHeight = '240px';
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'],
            datasets: [{
                label: 'Receitas',
                data: [600, 700, 800, 900, 1000, 2200],
                backgroundColor: '#68E570',
                borderColor: '#68E570',
                borderWidth: 8,
                barPercentage: 0.4, // Largura da barra
                categoryPercentage: 0.5 // Espaçamento entre grupos de barras
            },
                {
                    label: 'Despesas',
                    data: [600, 700, 800, 900, 1000, 1200],
                    backgroundColor: '#202228',
                    borderColor: '#202228',
                    borderWidth: 8,
                    barPercentage: 0.4, // Largura da barra
                    categoryPercentage: 0.5 // Espaçamento entre grupos de barras
                }]
        },
        options: {
            maintainAspectRatio: false, // Desativa o redimensionamento automático
            scales: {
                x: {
                    grid: {
                        display: false // Remove as linhas de grade verticais do eixo x
                    },
                    ticks: {
                        font: {
                            family: '"Lato", sans-serif',
                            size: 12
                        },
                        color: '#848894' // Cor das legendas dos valores
                    }
                },
                y: {
                    grid: {
                        color: '#8488942b' // Cor das linhas do gráfico
                    },
                    ticks: {
                        font: {
                            family: '"Lato", sans-serif',
                            size: 12
                        },
                        color: '#848894', // Cor das legendas dos valores
                        maxTicksLimit: 6, // Limita a exibição a 6 ticks
                        beginAtZero: true // Começa o eixo a partir de zero
                    }
                }
            },
            plugins: {
                legend: {
                    display: false // Remove a legenda
                }
            },
        }
    });
});
