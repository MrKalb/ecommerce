<%-- 
    Document   : add
    Created on : 30/04/2017, 12:50:25
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
        <h1 class="card-title">Adicionando cidade</h1>

        <form action="${linkTo[CidadeController].adiciona}" method="POST">
            <div class="form-group">
                <label class="form-label" for="cidade.descricao">Descricao</label>
                <br>
                <input class="form-control" type="text" id="cidade.descricao" name="cidade.descricao" placeholder="Digite o nome da Cidade">
            </div>
                <br>
                <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="estado" name="cidade.estado.id">
                <c:forEach items="${estadoList}" var="est">
                    <option value="${est.id}">${est.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>  
        </form>
    </body>
</html>
