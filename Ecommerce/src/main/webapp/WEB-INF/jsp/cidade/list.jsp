<%-- 
    Document   : list
    Created on : 30/04/2017, 13:34:54
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
        <h1 class="card-title">Listagem de cidades</h1>
        <table class="table-hover table-bordered">
            <tr> 
                <th>#Id</th>
                <th>Nome</th>
                <th>Estado</th>
            </tr>
            <c:forEach items="${cidadeList}" var="cid" varStatus="sts">
                <tr>
                    <td>${cid.id}</td>
                    <td>${cid.descricao}</td>
                    <td>${cid.estado.descricao}</td>
                    <td> <a href="${linkTo[CidadeController].show(cid)}">Editar</a></td>
                    <td> <a href="${linkTo[CidadeController].remove(cid)}">Remover</a> </td>
                </tr>
            </c:forEach>
            <a href="${linkTo[CidadeController].add}">adicionar cidade </a>
        </table>

    </body>
</html>
