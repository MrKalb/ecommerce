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
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <h1 class="card-title">Adicionando Transportadora</h1>
        <form action="${linkTo[TransportadoraController].adiciona}" method="POST">
            <div class="form-group">
                <label class="form-label" for="transportadora.razao">Razao Social </label>
                <br>
                <input class="form-control" type="text" id="transportadora.razao" name="transportadora.razao">
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.fantasia">Nome Fantasia</label>
                <br>
                <input class="form-control" type="text" id="transportadora.fantasia" name="transportadora.fantasia">
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.endereco">Endereco</label>
                <br>
                <input class="form-control" type="text" id="transportadora.endereco" name="transportadora.endereco">
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.cnpj">CNPJ</label>
                <br>
                <input class="form-control" type="text" id="transportadora.cnpj" name="transportadora.cnpj"> 
            </div>
            <br>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="cidade" name="transportadora.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
