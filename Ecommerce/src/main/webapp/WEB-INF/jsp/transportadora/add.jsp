<%-- 
    Document   : add
    Created on : 05/05/2017, 10:18:58
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lujinha</title>
    </head>
    <body>
        <h1>Adicionando Transportadora</h1>
        <form action="${linkTo[TransportadoraController].adiciona}" method="POST">
            <label for="transportadora.razao">Razao Social </label>
            <br>
            <input type="text" id="transportadora.razao" name="transportadora.razao">
            <br>
            <label for="transportadora.fantasia">Nome Fantasia</label>
            <br>
            <input type="text" id="transportadora.fantasia" name="transportadora.fantasia">
            <br>
            <label for="transportadora.endereco">Endereco</label>
            <br>
            <input type="text" id="transportadora.endereco" name="transportadora.endereco">
            <br>
            <label for="transportadora.cnpj">CNPJ</label>
            <br>
            <input type="text" id="transportadora.cnpj" name="transportadora.cnpj"> 
            <br>
            <select id="cidade" name="transportadora.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
