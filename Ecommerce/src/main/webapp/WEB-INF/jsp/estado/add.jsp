<%-- 
    Document   : adiciona
    Created on : 25/04/2017, 11:28:07
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
        <h1 class="card-title">Adicionando Estado!</h1>
        <form action="${linkTo[EstadoController].adiciona}" method="POST" >
            <div class="form-group">
            <label class="form-label" for="estado.descricao">Descricao</label>
            <br>
            <input class="form-control" type="text" id="estado.descricao" name="estado.descricao"  >
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button> 
        </form>
    </body>
</html>
