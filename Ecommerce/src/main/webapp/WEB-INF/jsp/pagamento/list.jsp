<%-- 
    Document   : list
    Created on : 04/05/2017, 14:35:05
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
        <h1 class="card-title">Lista de Formas de pagamento</h1>
        <table class="table-hover table-hover">
            <tr>
                <th>#Id</th>
                <th>Descricao</th>
            </tr>
            <c:forEach items="${pagamentoList}" var="pag" varStatus="sts">
                <tr>
                    <td>${pag.id}</td>
                    <td>${pag.descricao}</td>
                    <td> <a href="${linkTo[PagamentoController].show(pag)}">Editar </a></td>
                    <td> <a href="${linkTo[PagamentoController].remove(pag)}" onclick="return confirm('Deseja realmente excluir ?')">Remover</a>;
                </tr>
            </c:forEach>
        </table>
        <div class="card-footer">
            <a href="${linkTo[PagamentoController].adiciona}">Adicionar Forma</a>
        </div>
    </body>
</html>
