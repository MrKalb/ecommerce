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
    </head>
    <body>
        <h1>Auditoria</h1>
        <form action="${linkTo[EstoqueController].update}" method="POST">
            <input type="hidden" name="estoque.id" value="${estoque.id}"/>
            </br>
            <label for="produto">Escolha o produto</label>
            </br>
            <select id="produto" name="estoque.produto.id">
                <c:forEach items="${produtoList}" var="prod">
                    <option value="${prod.id}">${prod.descricao}</option>
                </c:forEach>
            </select>
            </br>
            <label for="quantidade">Digite a quantidade</label>
            </br>
            <input type="text" id="quantidade" name="quantidade">
            </br>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
