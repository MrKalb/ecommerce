<%-- 
    Document   : show
    Created on : 29/05/2017, 20:13:54
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
        <h1 class="card-title">Carrinho</h1>
        <form action="${linkTo[CarrinhoController].adicionaCarrinho}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <div class="card-text">
                <br>
                <p>"${produto.descricao}</p>
                <br>
            </div>
            <div class="card-text">
                <p>${produto.vlrVenda}</p>
                <br>
            </div>
            <div class="form-group">
                <label class="form-label" for="quantidade">Quantidade</label>
                <br>
                <input class="form-control" type="text" name="quantidade"  id="quantidade" placeholder="Quantidade">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button> 
        </form>
    </body>
</html>
