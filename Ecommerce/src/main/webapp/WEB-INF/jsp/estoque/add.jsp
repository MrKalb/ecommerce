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
    </head>
    <body>
        <h1>Estoque</h1>
        <form action="${linkTo[EstoqueController].adiciona}" method="POST">
            <label for="produto">Escolha o produto</label>
            </br>
            <select id="produto" name="estoque.produto.id">
                <c:forEach items="${produtoList}" var="prod">
                    <option value="${prod.id}">${prod.descricao}</option>
                </c:forEach>
            </select>
            </br>
            <label for="estoque.quantidade">Quantidade</label>
            </br>
            <input type="text" id="estoque.quantidade" name="estoque.quantidade">
            </br>
            <input type="submit" value="Salvar">  
        </form>
    </body>
</html>
