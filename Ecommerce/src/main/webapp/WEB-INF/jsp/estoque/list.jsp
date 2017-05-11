<%-- 
    Document   : list
    Created on : 11/05/2017, 16:58:59
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lujinha</title>
    </head>
    <body>
        <h1>Listagem Estoque</h1>
        <table border="1">
            <tr>
                <th>#Id</th>
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Açoes</th>
            </tr>
            <c:forEach items="${estoqueList}" var="est" varStatus="sts">
                <tr>
                    <td>${est.id}</td>
                    <td>${est.produto.descricao}</td>
                    <td>${est.quantidade}</td>
                    <td><a href="${linkTo[EstoqueController].show(est)}">editar</a></td>
                    <td><a href="${linkTo[EstoqueController].remove(est)}">Remover</a></td>
                </tr>
            </c:forEach>
            
            
        </table>
       
        
    </body>
</html>
