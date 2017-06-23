<%-- 
    Document   : show
    Created on : 28/04/2017, 19:33:57
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
        <h1 class="card-title">Editando Estado</h1>
            <form action="${linkTo[EstadoController].update}" method="POST">
                <input type="hidden" name="estado.id" value="${estado.id}"/>
                <div class="form-group">
                    <label class="form-label" for="estado.descricao">Descricao</label>
                <br>
                <input class="form-control" type="text" value="${estado.descricao}"  id="estado.descricao" name="estado.descricao"/>            
                </div>
                <br>
                <button class="btn btn-primary" type="submit">Salvar</button>
            </form>
    </body>
</html>
