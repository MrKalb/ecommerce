<%-- 
    Document   : add
    Created on : 03/05/2017, 15:01:41
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
        <h1 class="card-title">Adicionando Categoria!</h1>

        <form action="${linkTo[CategoriaController].adiciona}" method="POST">
            <div class="form-group">
                <label class="form-label" for="categoria.descricao">Descricao</label>
                <br>
                <input class="form-control" type="text" id="categoria.descricao" name="categoria.descricao" placeholder="Digite a descricao da categoria">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button> 
        </form>
    </body>
</html>
