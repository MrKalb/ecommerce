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
        <title>Listagem de cidades - Lujinha</title>
    </head>
    <body>
        <h1>Listagem de cidades</h1>
        <table border="1">
            <tr> 
                <th>#Id</th>
                <th>Nome</th>
                <th>Estado</th>
            </tr>
            <c:forEach items="${cidadeList}" var="cid">
                <tr>
                    <td>${cidade.descricao}</td>
                    <td>${cidade.estado}</td>
                    <td> <a href="${linkTo[CidadeController].show}">Editar</a></td>
                    <td> <a href="${linkTo[CidadeController].remove(cid)}">Remover</a> </td>
                </tr>
            </c:forEach>
                <a href="${linkTo[CidadeController].add}">adicionar cidade </a>
        </table>
        
    </body>
</html>
