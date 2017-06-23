<%-- 
    Document   : lista
    Created on : 21/06/2017, 10:59:49
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
        <c:import url="/WEB-INF/jsp/head.jsp"/>
        <h1 class="card-title">Listagem de Produtos por categoria</h1>
        <table class="table-hover table-bordered">
            <tr> 
                <th>Nome</th>
                <th>Valor</th>
            </tr>
            <c:forEach items="${listaList}" var="tip" varStatus="sts">
                <tr>
                    <td>${tip.descricao}</td>
                    <td>${tip.vlrVenda}</td>
                    <td> <a href="${linkTo[AdicionaController].removeItem(tip, tip.categoria.id)}">Remover</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
