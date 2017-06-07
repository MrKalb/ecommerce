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
        <form action="${linkTo[VendaController].finaliza}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <table>
                <tr>
                    <th>Produto</th>
                    <th>Valor</th>
                </tr>
                <c:forEach items="${itemList}" var="item" varStatus="sts">
                    <tr>
                        <td>${item.produto.descricao}</td>
                        <td>${item.produto.VlrVenda}</td>
                    </tr>
                </c:forEach>
            </table>
            <select id="transportadora" name="transportadora.id">
                <c:forEach items="${transpList}" var="tr" varStatus="sts">                    
                        <option value="${tr.id}">${tr.descricao}</option>
                </c:forEach>
            </select>
            <div>
                <p>Valor Frente</p>
                <p>${venda.vlrFrete}</p>
            </div>
        </form>
    </body>
</html>
