<%-- 
    Document   : list
    Created on : 26/04/2017, 11:06:05
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de estados</title>
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <h1 class="card-title">Estados-Cadastrados</h1>
        <table class="table-hover table-bordered">
            <tr>
                <th>#Id</th>
                <th>Nome</th>
            </tr>

            <c:forEach items="${estadoList}" var="est" varStatus="sts">
                <tr align="center">

                    <td>${est.id}</td>
                    <td>${est.descricao}</td>
                    <td><a href="${linkTo[EstadoController].show(est)}">editar</a></td>
                    <td><a href="${linkTo[EstadoController].remove(est)}" onclick="return confirm('Deseja realmente excluir ?')" >remover</a></td>
                </tr> 
            </c:forEach>    
        </table>
        <footer class="card-footer">
            <a href="${linkTo[EstadoController].add}">adicionar Estado</a>
            <br/>
            <a href="${linkTo[CidadeController].add}">Adicionar cidade</a>
        </footer>
    </body>
</html>
