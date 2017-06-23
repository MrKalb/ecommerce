<%-- 
    Document   : list
    Created on : 22/06/2017, 17:45:01
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lujinha</title>
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
         <c:import url="/WEB-INF/jsp/nav.jsp"/>
        <h1>Carrinho</h1>
        <table class="table-hover table-bordered">
            <tr>
                <th colspan="2">Descricao</th>
                <th colspan="1">Valor Produto</th>
                <th colspan="1">Quantidade</th>
            </tr>
                <c:forEach items="${itemList}" var="item" varStatus="sts">
                    <tr>
                        <td colspan="2">${item.produto.descricao}</td>
                        <td colspan="1">${item.produto.vlrVenda}</td>
                        <td colspan="1">${item.quantidade}</td>
                    </tr>
                </c:forEach>
        </table>
        <div class="card-container card-block">
            <div class="card-text text-right">
                    <label>Total de produtos</label>
                    <br>
                    <label>${preco}</label>
                </div>
                <br>
                <div class="card-text text-right">
                    <label>Frete</label>
                    <br>
                    <label>${frete}</label>
                </div>
                <br>
                <div class="card-text text-right">
                    <label>Total</label>
                    <br>
                    <label>${total}</label>
                </div>
        </div>
                <footer class="card-footer">
                    <a class="card-text" href="${linkTo[VendaController].finaliza}">Finalizar Venda</a>
                </footer>
    </body>
</html>
