<%-- 
    Document   : finaliza
    Created on : 07/06/2017, 10:25:12
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Finalizando Venda</h1>
        <form action="${linkTo[VendaController].finalizaVenda}" method="POST">
            <input type="hidden" name="carrinho.id" value="${carrinho.id}"/>
            <table>
                <tr>
                    <th>Produto</th>
                    <th>Valor</th>
                </tr>
                <br>
                <c:forEach items="${itemList}" var="item" varStatus="sts">
                    <tr>
                        <td>${item.produto.descricao}</td>
                        <td>${item.produto.vlrVenda}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <select id="transportadora" name="venda.transportadora.id">
                <c:forEach items="${transpList}" var="tr" varStatus="sts">                    
                        <option value="${tr.id}">${tr.razao}</option>
                </c:forEach>
            </select>
            <br>
            <select id="formapagamento" name="venda.forma.id">
                <c:forEach items="${formaList}" var="fp" varStatus="sts">                    
                        <option value="${fp.id}">${fp.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Confirmar">
        </form>
    </body>
</html>
