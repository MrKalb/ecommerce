<%-- 
    Document   : show
    Created on : 10/05/2017, 15:35:44
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="/WEB-INF/jsp/head.jsp"/>
        <title>Lujinha</title>
        
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <h1 class="card-title">Editando Produto</h1>
        <form action="${linkTo[ProdutoController].update}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <br>
            <div class="form-group">
                <label class="form-label" for="produto.descricao">Descricao</label>
            <br>
            <input class="form-control" type="text" name="produto.descricao" value="${produto.descricao}" id="produto.descricao">
            <br>
            </div>
            <div class="form-group">
                <label class="form-label" for="produto.vlrVenda">Valor</label>
            <br>
            <input class="form-control" type="text" name="produto.vlrVenda" value="${produto.vlrVenda}" id="produto.vlrVenda">
            <br>
            </div>
            <div class="form-group">
                <label class="form-label" for="produto.codBarras">CodBarras</label>
            <br>
            <input class="form-control" type="text" name="produto.codBarras" value="${produto.codBarras}" id="produto.codBarras">
            <br>
            </div>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
