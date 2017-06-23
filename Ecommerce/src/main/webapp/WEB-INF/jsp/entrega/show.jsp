<%-- 
    Document   : show
    Created on : 23/06/2017, 13:57:28
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
        <h1 class="card-title">Atualizando Status</h1>
        <form action="${linkTo[EntregaController].update}" method="POST">
            <input type="hidden" name="entrega.id" value="${entrega.id}"/>
            <div class="form-group">
                <label class="form-label" for="entrega.status">Status</label> 
                <br>
                <input class="form-control" type="text" value="${entrega.status}" id="entrega.status" name="entrega.status">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button> 
        </form>
    </body>
</html>
