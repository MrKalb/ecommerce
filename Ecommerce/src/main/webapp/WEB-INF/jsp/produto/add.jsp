<%-- 
    Document   : add
    Created on : 10/05/2017, 15:07:28
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
        <h1>Adicionando produtos</h1>
        <form action="${linkTo[ProdutoController].adiciona}" method="POST">
            <div class="form-group">
            <input class="form-control" type="text" id="produto.descricao" name="produto.descricao" placeholder="Digite a descricao">  
        <br>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" id="produto.vlrVenda" name="produto.vlrVenda" placeholder="Digite o valor">
        <br>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" id="produto.codBarras" name="produto.codBarras" placeholder="Digite o codigo de barras">
        <br>
            </div>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
