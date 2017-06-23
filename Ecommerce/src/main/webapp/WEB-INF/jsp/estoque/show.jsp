<%-- 
    Document   : show
    Created on : 11/05/2017, 17:23:36
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
        <h1 class="card-title">Auditoria</h1>
        <form action="${linkTo[EstoqueController].update}" method="POST">
            <input type="hidden" name="estoque.id" value="${estoque.id}"/>
            <br>

            <label class="form-label" for="produto">Escolha o produto</label>
            <br>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="produto" name="estoque.produto.id">
                <c:forEach items="${produtoList}" var="prod">
                    <option value="${prod.id}">${prod.descricao}</option>
                </c:forEach>
            </select>

            <br>
            <div class="form-group">
                <label class="form-label" for="quantidade">Digite a quantidade</label>
                <br>
                <input class="form-control" type="text" value="${estoque.quantidade}"  id="estoque.quantidade" name="estoque.quantidade"/>    
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
