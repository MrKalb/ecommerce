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
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <h1 class="card-title">Listagem Estoque</h1>
        <table class="table-hover table-bordered">
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
       
        <footer class="card-footer">
            <a href="${linkTo[EstoqueController].adiciona}">Adicionar</a>
        </footer>
        
    </body>
</html>
