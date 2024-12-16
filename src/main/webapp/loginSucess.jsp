<%@ page import="model.Conta" %>
<%@ page import="model.Usuario" %>
<%@ page import="transaction.Receita" %>
<%@ page import="transaction.Despesa" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech</title>
    <link rel="stylesheet" href="resources/css/output.css">
</head>
<body>
<div class="layoutContainer">
    <!-- Modal de Cadastro de Receita -->
    <div id="modalContainer" class="modalContainer"></div>
    <div class="layoutAside">
        <aside>
            <div class="asideInner">
                <div class="asideContent">
                    <ul>
                        <li>
                            <a href="#">
                                <svg width="24" height="32" viewBox="0 0 24 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M6.05001 22.6249H9.32501V17.5249C9.32501 17.2291 9.43026 16.9759 9.64076 16.7654C9.8511 16.5551 10.1042 16.4499 10.4 16.4499H13.6C13.8958 16.4499 14.149 16.5551 14.3595 16.7654C14.5698 16.9759 14.675 17.2291 14.675 17.5249V22.6249H17.95V14.0749C17.95 13.9416 17.9208 13.8207 17.8625 13.7124C17.8042 13.6041 17.725 13.5082 17.625 13.4249L12.475 9.5499C12.3417 9.43324 12.1833 9.3749 12 9.3749C11.8167 9.3749 11.6583 9.43324 11.525 9.5499L6.37501 13.4249C6.27501 13.5082 6.19585 13.6041 6.13751 13.7124C6.07918 13.8207 6.05001 13.9416 6.05001 14.0749V22.6249ZM4.70001 22.6249V14.0749C4.70001 13.7336 4.77751 13.4102 4.93251 13.1047C5.08735 12.7992 5.30151 12.5476 5.57501 12.3499L10.725 8.4499C11.1197 8.16657 11.5433 8.0249 11.996 8.0249C12.4487 8.0249 12.875 8.16657 13.275 8.4499L18.425 12.3499C18.6985 12.5476 18.9127 12.7992 19.0675 13.1047C19.2225 13.4102 19.3 13.7336 19.3 14.0749V22.6249C19.3 23.0082 19.1708 23.3291 18.9125 23.5874C18.6542 23.8457 18.3333 23.9749 17.95 23.9749H14.4C14.1042 23.9749 13.8511 23.8697 13.6408 23.6592C13.4303 23.4488 13.325 23.1957 13.325 22.8999V17.7999H10.675V22.8999C10.675 23.1957 10.5698 23.4488 10.3595 23.6592C10.149 23.8697 9.89585 23.9749 9.60001 23.9749H6.05001C5.66668 23.9749 5.34585 23.8457 5.08751 23.5874C4.82918 23.3291 4.70001 23.0082 4.70001 22.6249Z" fill="#848894"/>
                                </svg>
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <svg width="24" height="32" viewBox="0 0 24 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M7.05 22.2259C6.80917 22.2259 6.60725 22.1445 6.44425 21.9817C6.28142 21.8187 6.2 21.6168 6.2 21.3759V20.2759H18.475L19.3 21.1009V11.2259H20.3917C20.6456 11.2259 20.8521 11.3074 21.0113 11.4704C21.1704 11.6333 21.25 11.8351 21.25 12.0759V23.1009C21.25 23.5696 21.0292 23.8951 20.5875 24.0774C20.1458 24.2598 19.7583 24.1843 19.425 23.8509L17.8 22.2259H7.05ZM6.2 18.2759L4.575 19.9009C4.24167 20.2343 3.85417 20.3098 3.4125 20.1274C2.97083 19.9451 2.75 19.6196 2.75 19.1509V8.67593C2.75 8.43509 2.8315 8.23326 2.9945 8.07043C3.15733 7.90743 3.35917 7.82593 3.6 7.82593H16.45C16.6908 7.82593 16.8927 7.90743 17.0555 8.07043C17.2185 8.23326 17.3 8.43509 17.3 8.67593V17.4259C17.3 17.6668 17.2185 17.8686 17.0555 18.0314C16.8927 18.1944 16.6908 18.2759 16.45 18.2759H6.2ZM15.95 16.9259V9.17593H4.1V18.7259L5.9 16.9259H15.95Z" fill="#848894"/>
                                </svg>
                                Suporte
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <svg width="24" height="32" viewBox="0 0 24 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M10.4125 25.5251C10.2625 25.5251 10.1212 25.4733 9.98873 25.3698C9.85607 25.2663 9.77232 25.1348 9.73748 24.9751L9.43748 22.5501C9.18748 22.4668 8.88098 22.3297 8.51798 22.1388C8.15498 21.9478 7.86148 21.7433 7.63748 21.5251L5.38748 22.4751C5.23748 22.5418 5.08332 22.5501 4.92498 22.5001C4.76665 22.4501 4.65415 22.3501 4.58748 22.2001L2.93748 19.2501C2.87082 19.1001 2.84582 18.9543 2.86248 18.8126C2.87915 18.6709 2.95415 18.5584 3.08748 18.4751L4.98748 17.0251C4.97082 16.8596 4.94998 16.6846 4.92498 16.5001C4.89998 16.3156 4.88748 16.1406 4.88748 15.9751C4.88748 15.8349 4.89998 15.6808 4.92498 15.5126C4.94998 15.3444 4.97082 15.1486 4.98748 14.9251L3.11248 13.5251C2.97915 13.4418 2.90832 13.3209 2.89998 13.1626C2.89165 13.0043 2.92082 12.8501 2.98748 12.7001L4.61248 9.9001C4.67915 9.76676 4.78748 9.6751 4.93748 9.6251C5.08748 9.5751 5.23748 9.5751 5.38748 9.6251L7.51248 10.5001C7.79582 10.2668 8.11248 10.0543 8.46248 9.8626C8.81248 9.67093 9.13748 9.51676 9.43748 9.4001L9.73748 7.0251C9.75415 6.85843 9.83332 6.7251 9.97498 6.6251C10.1167 6.5251 10.2625 6.4751 10.4125 6.4751H13.6125C13.7625 6.4751 13.9083 6.5251 14.05 6.6251C14.1917 6.7251 14.2708 6.85843 14.2875 7.0251L14.5625 9.4501C14.9125 9.6001 15.2333 9.75426 15.525 9.9126C15.8167 10.0709 16.1125 10.2751 16.4125 10.5251L18.6375 9.6251C18.7828 9.55843 18.9323 9.55426 19.086 9.6126C19.2397 9.67093 19.3568 9.76676 19.4375 9.9001L21.0625 12.7251C21.1292 12.8751 21.1542 13.0251 21.1375 13.1751C21.1208 13.3251 21.0458 13.4418 20.9125 13.5251L18.8875 15.0501C18.9375 15.2334 18.9667 15.4084 18.975 15.5751C18.9833 15.7418 18.9875 15.8918 18.9875 16.0251C18.9875 16.1418 18.9792 16.2834 18.9625 16.4501C18.9458 16.6168 18.9292 16.8168 18.9125 17.0501L20.8125 18.4751C20.9458 18.5584 21.0292 18.6751 21.0625 18.8251C21.0958 18.9751 21.0792 19.1251 21.0125 19.2751L19.4125 22.1751C19.3458 22.3251 19.2264 22.4251 19.0542 22.4751C18.8819 22.5251 18.718 22.5168 18.5625 22.4501L16.2875 21.5001C16.0042 21.7334 15.725 21.9334 15.45 22.1001C15.175 22.2668 14.8875 22.4001 14.5875 22.5001L14.2875 24.9751C14.2527 25.1348 14.1689 25.2663 14.0362 25.3698C13.9037 25.4733 13.7625 25.5251 13.6125 25.5251H10.4125ZM10.9875 24.1751H12.9587L13.3375 21.4251C13.8542 21.2918 14.3201 21.1078 14.7352 20.8731C15.1506 20.6383 15.5847 20.3056 16.0375 19.8751L18.4875 20.9251L19.5125 19.2251L17.3625 17.5751C17.4458 17.2751 17.5042 16.9982 17.5375 16.7443C17.5708 16.4905 17.5875 16.2363 17.5875 15.9818C17.5875 15.7107 17.575 15.4668 17.55 15.2501C17.525 15.0334 17.4708 14.7584 17.3875 14.4251L19.5625 12.7751L18.5875 11.0751L16.0375 12.1001C15.7542 11.7668 15.3426 11.4435 14.8027 11.1303C14.2627 10.817 13.766 10.6153 13.3125 10.5251L13.0375 7.8251H10.9625L10.7125 10.4751C10.1458 10.5918 9.63748 10.7793 9.18748 11.0376C8.73748 11.2959 8.29582 11.6501 7.86248 12.1001L5.43748 11.0751L4.41248 12.7751L6.51248 14.4001C6.42915 14.6834 6.37082 14.9584 6.33748 15.2251C6.30415 15.4918 6.28748 15.7453 6.28748 15.9856C6.28748 16.1953 6.30415 16.4334 6.33748 16.7001C6.37082 16.9668 6.42082 17.2668 6.48748 17.6001L4.41248 19.2251L5.43748 20.9251L7.86248 19.9001C8.32915 20.3334 8.78332 20.6709 9.22498 20.9126C9.66665 21.1543 10.1542 21.3418 10.6875 21.4751L10.9875 24.1751ZM11.8875 18.8751C12.6975 18.8751 13.3833 18.5943 13.945 18.0326C14.5067 17.4709 14.7875 16.7851 14.7875 15.9751C14.7875 15.1651 14.5067 14.4793 13.945 13.9176C13.3833 13.3559 12.6975 13.0751 11.8875 13.0751C11.0875 13.0751 10.4042 13.3559 9.83748 13.9176C9.27082 14.4793 8.98748 15.1651 8.98748 15.9751C8.98748 16.7851 9.27082 17.4709 9.83748 18.0326C10.4042 18.5943 11.0875 18.8751 11.8875 18.8751Z" fill="#848894"/>
                                </svg>
                                Configurações
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="asideLeave">
                    <a href="#" id="theme-toggle" style="color: var(--gray-text);">
                        <svg width="24" height="32" viewBox="0 0 24 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path class="fill-borderDark  -hover:fill-white" d="M12.0043 25.5C10.6908 25.5 9.45567 25.2507 8.299 24.7522C7.14233 24.2537 6.13625 23.5772 5.28075 22.7225C4.42508 21.8678 3.74775 20.8629 3.24875 19.7078C2.74958 18.5524 2.5 17.3179 2.5 16.0043C2.5 14.6908 2.74925 13.4557 3.24775 12.299C3.74625 11.1423 4.42283 10.1362 5.2775 9.28075C6.13217 8.42508 7.13708 7.74775 8.29225 7.24875C9.44758 6.74958 10.6821 6.5 11.9957 6.5C13.3092 6.5 14.5443 6.74925 15.701 7.24775C16.8577 7.74625 17.8638 8.42283 18.7193 9.2775C19.5749 10.1322 20.2522 11.1371 20.7512 12.2923C21.2504 13.4476 21.5 14.6821 21.5 15.9957C21.5 17.3092 21.2508 18.5443 20.7523 19.701C20.2538 20.8577 19.5772 21.8638 18.7225 22.7193C17.8678 23.5749 16.8629 24.2522 15.7078 24.7512C14.5524 25.2504 13.3179 25.5 12.0043 25.5ZM12.2 24.175C14.3833 24.0583 16.2542 23.231 17.8125 21.693C19.3708 20.155 20.15 18.2573 20.15 16C20.15 13.7427 19.3792 11.8533 17.8375 10.332C16.2958 8.81067 14.4167 7.975 12.2 7.825V24.175Z" fill="#848894"/>
                        </svg>
                        Alterar o tema
                    </a>
                    <a href="logout.jsp">
                        <svg width="24" height="32" viewBox="0 0 24 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M5.87498 24.5C5.25831 24.5 4.74581 24.2958 4.33748 23.8875C3.92914 23.4792 3.72498 22.9667 3.72498 22.35V9.65C3.72498 9.03333 3.92914 8.52083 4.33748 8.1125C4.74581 7.70417 5.25831 7.5 5.87498 7.5H11.575C11.7583 7.5 11.9166 7.56667 12.05 7.7C12.1833 7.83333 12.25 7.99167 12.25 8.175C12.25 8.35833 12.1833 8.51667 12.05 8.65C11.9166 8.78333 11.7583 8.85 11.575 8.85H5.87498C5.67498 8.85 5.49164 8.93333 5.32498 9.1C5.15831 9.26667 5.07498 9.45 5.07498 9.65V22.35C5.07498 22.55 5.15831 22.7333 5.32498 22.9C5.49164 23.0667 5.67498 23.15 5.87498 23.15H11.575C11.7583 23.15 11.9166 23.2167 12.05 23.35C12.1833 23.4833 12.25 23.6417 12.25 23.825C12.25 24.0083 12.1833 24.1667 12.05 24.3C11.9166 24.4333 11.7583 24.5 11.575 24.5H5.87498ZM18.025 16.65H9.99998C9.81664 16.65 9.65831 16.5833 9.52498 16.45C9.39164 16.3167 9.32498 16.1583 9.32498 15.975C9.32498 15.7917 9.39164 15.6333 9.52498 15.5C9.65831 15.3667 9.81664 15.3 9.99998 15.3H18.025L16.1 13.375C15.95 13.225 15.8708 13.0542 15.8625 12.8625C15.8541 12.6708 15.9333 12.5 16.1 12.35C16.2666 12.2 16.4333 12.1292 16.6 12.1375C16.7666 12.1458 16.925 12.225 17.075 12.375L19.95 15.25C20.1666 15.4667 20.275 15.7167 20.275 16C20.275 16.2833 20.1666 16.5333 19.95 16.75L17.1 19.6C16.9666 19.7333 16.8041 19.8083 16.6125 19.825C16.4208 19.8417 16.25 19.7667 16.1 19.6C15.9333 19.45 15.8458 19.2875 15.8375 19.1125C15.8291 18.9375 15.9083 18.7667 16.075 18.6L18.025 16.65Z" fill="#DB4931"/>
                        </svg>
                        Sair
                    </a>
                </div>
            </div>
        </aside>
    </div>
    <main class="layoutMain">
        <div class="layoutHeader">
            <!-- <header>HEADER</header> -->
            <h1>Bem-vindo, ${usuario.nome}!</h1>
        </div>
        <div class="layoutBody">
            <div class="firstSection">
                <div class="leftContainer">
                    <!-- Verifica se o usu�rio possui contas cadastradas -->
                    <c:if test="${empty contas}">
                        <p>Voc� n�o possui contas cadastradas.</p>
                    </c:if>

                    <!-- Exibe as contas, saldo, receitas e despesas se houver -->
                    <c:if test="${not empty contas}">
                        <c:forEach var="conta" items="${contas}">
                            <div class="accountInfo">
                                <div class="accountImg">

                                </div>
                                <div class="accountDetails">
                                    <h3>${conta.nomeBanco}</h3>
                                    <div class="accountAmount">
                                        <p>${conta.tipoConta}</p>
                                        <p>R$ ${conta.saldo}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <div class="transactionHistory" data-receitas-totais="${totaisReceitas[contas[0].cdConta] != null ? totaisReceitas[contas[0].cdConta] : 0}" data-despesas-totais="${totaisDespesas[contas[0].cdConta] != null ? totaisDespesas[contas[0].cdConta] : 0}">
                        <div class="circleGraphContainer">
                            <div class="circleGrap">
                                <svg viewBox="0 0 128 128">
                                    <circle class="circleGrapBackground" stroke-width="10" stroke="currentColor" fill="transparent" r="56" cx="64" cy="64"/>
                                    <circle id="progressCircle" class="circleGrapProgress" stroke-width="10" stroke-dasharray="351.86" stroke-dashoffset="351.86" stroke-linecap="" stroke="currentColor" fill="transparent" r="56" cx="64" cy="64"/>
                                </svg>
                                <div class="currentBalanceDetails">
                                    <span class="currentBalanceTitle">Saldo atual</span>
                                    <span class="currentBalance">
                                        <c:if test="${not empty contas}">
                                            <c:forEach var="conta" items="${contas}">
                                                R$ ${conta.saldo}
                                            </c:forEach>
                                        </c:if>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <hr class="transactionHistoryDivisor">
                        <div class="transactionsValuesContainer">
                            <c:forEach var="conta" items="${contas}">
                                <div class="transactionValueBox currentIncome">
                                    <span class="transactionValueTitle">Receitas mensal</span>
                                    <span class="transactionValue currentIncomeValue">R$ ${totaisReceitas[conta.cdConta]}</span>
                                </div>
                                <div class="transactionValueBox currentExpense">
                                    <span class="transactionValueTitle">Despesas mensal</span>
                                    <span class="transactionValue currentExpenseValue">R$ ${totaisDespesas[conta.cdConta]}</span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <button href="" class="btnTransaction btnIncome" data-modal-url="resources/modal/cadastroReceitaModal.html">
                        <div class="iconBtnTransaction iconBtnIncome w-12 h-12 justify-center bg-[#68e5703d] rounded-lg">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                                <path d="M12 21C13.1819 21 14.3522 20.7672 15.4442 20.3149C16.5361 19.8626 17.5282 19.1997 18.364 18.364C19.1997 17.5282 19.8626 16.5361 20.3149 15.4442C20.7672 14.3522 21 13.1819 21 12C21 10.8181 20.7672 9.64778 20.3149 8.55585C19.8626 7.46392 19.1997 6.47177 18.364 5.63604C17.5282 4.80031 16.5361 4.13738 15.4442 3.68508C14.3522 3.23279 13.1819 3 12 3C9.61305 3 7.32387 3.94821 5.63604 5.63604C3.94821 7.32387 3 9.61305 3 12C3 14.3869 3.94821 16.6761 5.63604 18.364C7.32387 20.0518 9.61305 21 12 21Z" stroke="#68E570" stroke-opacity="0.72" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M9 12H15" stroke="#68E570" stroke-opacity="0.72" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M12 9V15" stroke="#68E570" stroke-opacity="0.72" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            </svg>
                        </div>
                        <div class="btnTransactionDetails">
                            <span class="btnTransactionTitle">Adicionar receita</span>
                            <span class="btnTransactionDesc">Crie uma receita manualmente</span>
                        </div>
                    </button>
                    <button class="btnTransaction btnExpense" data-modal-url="resources/modal/cadastroDespesaModal.html">
                        <div class="iconBtnTransaction iconBtnExpense w-12 h-12 justify-center bg-[#db49313d] rounded-lg">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                                <path d="M12 21C13.1819 21 14.3522 20.7672 15.4442 20.3149C16.5361 19.8626 17.5282 19.1997 18.364 18.364C19.1997 17.5282 19.8626 16.5361 20.3149 15.4442C20.7672 14.3522 21 13.1819 21 12C21 10.8181 20.7672 9.64778 20.3149 8.55585C19.8626 7.46392 19.1997 6.47177 18.364 5.63604C17.5282 4.80031 16.5361 4.13738 15.4442 3.68508C14.3522 3.23279 13.1819 3 12 3C9.61305 3 7.32387 3.94821 5.63604 5.63604C3.94821 7.32387 3 9.61305 3 12C3 14.3869 3.94821 16.6761 5.63604 18.364C7.32387 20.0518 9.61305 21 12 21Z" stroke="#DB4931" stroke-opacity="0.72" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M9 12H15" stroke="#DB4931" stroke-opacity="0.72" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            </svg>
                        </div>
                        <div class="btnTransactionDetails">
                            <span class="btnTransactionTitle">Adicionar despesa</span>
                            <span class="btnTransactionDesc">Crie uma despesa manualmente</span>
                        </div>
                    </button>
                </div>
                <div class="rightContainer">
                    <div class="contentContainer monthlyAnalysis">
                        <div class="contentContainerTitle">
                            <h2>Análise mensal</h2>
                        </div>
                        <div style="width: 100%">
                            <canvas class="myChart"></canvas>
                        </div>
                    </div>
                    <div class="contentContainer transactionHistory">
                        <div class="contentContainerTitle">
                            <h2>Historico de Transações</h2>
                            <!-- Combobox de Filtro -->
                            <div class="filterSelect">
                                <label for="transactionFilter">Filtrar:</label>
                                <select id="transactionFilter" onchange="filterTransactions(this.value)">
                                    <option value="all">Mostrar Tudo</option>
                                    <option value="receita">Receitas</option>
                                    <option value="despesa">Despesas</option>
                                </select>
                            </div>
                        </div>
                        <!-- Tabela de Hist�rico de Transa��es -->
                        <div class="transactionTableContainer">
                            <table class="transactionTable" border="1">
                                <thead>
                                <tr>
                                    <th onclick="sortTable(0)">Tipo</th>
                                    <th onclick="sortTable(1)">Nome</th>
                                    <th onclick="sortTable(2)">Valor</th>
                                    <th onclick="sortTable(3)">Data</th>
                                    <th onclick="sortTable(4)">Hora</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- Loop para exibir Receitas e Despesas -->
                                <c:forEach var="conta" items="${contas}">
                                    <c:forEach var="receita" items="${receitasPorConta[conta.cdConta]}">
                                        <tr class="transactionRow receita">
                                            <td>Receita</td>
                                            <td>${receita.nomeReceita}</td>
                                            <td>R$ ${receita.valor}</td>
                                            <td><fmt:formatDate value="${receita.data}" pattern="dd/MM/yy"/></td>
                                            <td>${receita.hora}</td>
                                        </tr>
                                    </c:forEach>

                                    <c:forEach var="despesa" items="${despesasPorConta[conta.cdConta]}">
                                        <tr class="transactionRow despesa">
                                            <td>Despesa</td>
                                            <td>${despesa.nomeDespesa}</td>
                                            <td>R$ ${despesa.valor}</td>
                                            <td><fmt:formatDate value="${despesa.data}" pattern="dd/MM/yy"/></td>
                                            <td>${despesa.hora}</td>
                                        </tr>
                                    </c:forEach>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script src="resources/js/barChartHome.js"></script>
<script src="resources/js/progressCircle.js"></script>
<script src="resources/js/filterTransactions.js"></script>
<script src="resources/js/modalManager.js"></script>
<script src="resources/js/ajaxRequest.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script src="js/barChart.js"></script>
<script src="js/progress.js"></script>
<script src="js/themeChange.js"></script> -->
</body>
</html>