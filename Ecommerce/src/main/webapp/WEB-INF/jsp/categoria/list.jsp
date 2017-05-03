<%-- 
    Document   : list
    Created on : 03/05/2017, 15:07:49
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categorias</title>
    </head>
    <body>
        <h1>Listagem de Categorias</h1>
        <table border="1">
            <tr>
                <th>#ID</th>
                <th>Descricao</th>
            </tr>
            
            <c:forEach items="${categoriaList}" var="cat" varStatus="sts">
                <tr>
                    <td>${cat.id}</td>
                    <td>${cat.descricao}</td>
                    <td><a href="${linkTo[CategoriaController].show(cat)}">Editar</a></td>
                    <td><a href="${linkTo[CategoriaController].remove(cat)}">Remover</a></td>
                </tr>
            </c:forEach>
                <a href="${linkTo[CategoriaController].add}">Adicionar categoria</a>
        </table>
    </body>
</html>
