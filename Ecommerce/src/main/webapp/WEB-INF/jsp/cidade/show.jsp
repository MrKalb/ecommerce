<%-- 
    Document   : show
    Created on : 03/05/2017, 10:38:25
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando cidade</title>
    </head>
    <body>
        <h1>Editando a cidade ${cidade.id}</h1>
        <form action="${linkTo[CidadeController].update}" method="POST">
            <input type="hidden" name="cidade.id" value="${cidade.id}"/>
            <label for="cidade.descricao">Descricao</label> 
            </br>
            <input type="text" value="${cidade.descricao}" id="cidade.descricao" name="cidade.descricao">
            </br>
            <label for="estado">Escolha o estado</label>
            </br>
            <select id="estado" name="cidade.estado.id">
                <c:forEach items="${estadoList}" var="est">
                    <option value="${est.id}">${est.descricao}</option>
                </c:forEach>
            </select>
            </br>
            <input type="submit" value="salvar">
            
        </form>
        
    </body>
</html>
