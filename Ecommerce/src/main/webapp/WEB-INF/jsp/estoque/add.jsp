<%-- 
    Document   : add
    Created on : 11/05/2017, 16:49:09
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
        <h1 class="card-title">Estoque</h1>
        <form action="${linkTo[EstoqueController].adiciona}" method="POST">
            <label class="form-label" for="produto">Escolha o produto</label>
            <br>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="produto" name="estoque.produto.id">
                <c:forEach items="${produtoList}" var="prod">
                    <option value="${prod.id}">${prod.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <div class="form-group">
                <label class="form-label" for="estoque.quantidade">Quantidade</label>
            <br>
            <input class="form-control" type="text" id="estoque.quantidade" name="estoque.quantidade">
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
