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
        <title>Adicionando Cidade</title>
    </head>
    <body>
        <h1>Adicionando cidade !! </h1>

        <form action="${linkTo[CidadeController].adiciona}" method="POST">

            <input type="text" id="cidade.descricao" name="cidade.descricao" placeholder="Digite o nome da Cidade">
            </br>
            <select id="estado" name="estado.id">
                <c:forEach items="${estadoList}" var="est">
                    <option value="${est.id}">${est.descricao}</option>
                </c:forEach>
            </select>
            </br>
            <input type="submit" value="salvar">
        </form>
    </body>
</html>
