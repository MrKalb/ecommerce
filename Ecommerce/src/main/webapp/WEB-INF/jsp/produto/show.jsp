<%-- 
    Document   : show
    Created on : 10/05/2017, 15:35:44
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Lujinha</title>
    </head>
    <body>
        <h1>Editando Produto</h1>
        <form action="${linkTo[ProdutoController].update}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <br>
            <label for="produto.descricao">Descricao</label>
            <br>
            <input type="text" name="produto.descricao" value="${produto.descricao}" id="produto.descricao">
            <br>
            <label for="produto.vlrVenda">Valor</label>
            <br>
            <input type="text" name="produto.vlrVenda" value="${produto.vlrVenda}" id="produto.vlrVenda">
            <br>
            <label for="produto.codBarras">CodBarras</label>
            <br>
            <input type="text" name="produto.codBarras" value="${produto.codBarras}" id="produto.codBarras">
            <br>
            <input type="submit" value="salvar">
        </form>

        <form action="${linkTo[AdicionaController].adicionaCategoria()}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <select multiple>
                <c:forEach items="${categoriaList}" var="cat" varStatus="sts">
                    <option value="${cat.id}">${cat.descricao}</option> 
            </select>
                </c:forEach>
            <input type="submit" value="salvar">
        </form>
    </body>
</html>
