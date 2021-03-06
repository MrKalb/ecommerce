<%-- 
    Document   : list
    Created on : 05/05/2017, 10:48:23
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
        <h1 class="card-title">Lista de Transportadoras</h1>
        <table class="table-hover table-bordered">
            <tr>
                <th>#Id</th>
                <th>Razao</th>
                <th>Fantasia</th>
                <th>Endereco</th>
                <th>CNPJ</th>
                <th>Cidade</th>
            </tr>
            <c:forEach items="${transportadoraList}" var="tr" varStatus="sts">
                <tr>
                    <td>${tr.id}</td>
                    <td>${tr.razao}</td>
                    <td>${tr.fantasia}</td>
                    <td>${tr.endereco}</td>
                    <td>${tr.cnpj}</td>
                    <td>${tr.cidade.descricao}</td>
                    <td><a href="${linkTo[TransportadoraController].show(tr)}">Editar</a></td>
                    <td><a href="${linkTo[TransportadoraController].remove(tr)}" onclick="return confirm('Deseja realmente excluir ?')">Remover</a></td>

                </tr>
            </c:forEach>
        </table>
        <footer class="card-footer">
            <a href="${linkTo[TransportadoraController].adiciona}">Adiciona</a>
        </footer>
    </body>
</html>
