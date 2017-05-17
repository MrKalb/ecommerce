<%-- 
    Document   : add
    Created on : 11/05/2017, 14:57:52
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
        <h1>Adicionando Categorias</h1>
        <form action="${linkTo[AdicionaController].adicionaCategoria}" method="POST">
            <label>Escolha o produto</label>
            <br>
            <select id="produto" name="produto.id">
            <c:forEach items="${produtoList}" var="prod" varStatus="sts">
                <option value="${prod.id}">${prod.descricao}</option>
            </c:forEach>
        </select>
            <br>
            <label>Escolha a Categoria</label>
            <br>
            <select id="categoria" name="categoria.id">
                <c:forEach items="${categoriaList}" var="cat" varStatus="sts">
                    <option value="${cat.id}">${cat.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
