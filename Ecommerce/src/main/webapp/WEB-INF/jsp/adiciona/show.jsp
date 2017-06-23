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
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <h1 class="card-title">Adicionando Categorias</h1>
        <form action="${linkTo[AdicionaController].adicionaCategoria}" method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/>
            <div class="card-text">
            <br>
            <p>${produto.descricao}</p>
            <br>
            </div>
            <label class="form-label" for="categoria">Escolha a Categoria</label>
            <br>
            <select id="categoria" name="categoria.id">
                <c:forEach items="${categoriaList}" var="cat" varStatus="sts">
                    <option value="${cat.id}">${cat.descricao}</option>
                </c:forEach>
            </select>
            <br>
           <button class="btn btn-primary" type="submit">Salvar</button> 
        </form>
    </body>
</html>
