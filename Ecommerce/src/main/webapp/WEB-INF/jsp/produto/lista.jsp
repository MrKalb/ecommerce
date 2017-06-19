<%-- 
    Document   : lista
    Created on : 19/06/2017, 16:10:15
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
        <h1>Hello World!</h1>
        
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Descricao</th>
                <th>Valor</th>
                <th>Açoes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${produtoList}" var="prod" varStatus="sts">
                <tr>
                    <td>${prod.descricao}</td>
                    <td>${prod.vlrVenda}</td>
                    <td><a href="${linkTo[CarrinhoController].show(prod)}">Adicionar a carrinho</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
