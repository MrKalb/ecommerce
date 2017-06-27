<%-- 
    Document   : show
    Created on : 27/06/2017, 08:17:19
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
        <c:import url="/WEB-INF/jsp/nav.jsp"/>
        <h1>Alterando dados</h1>
        <br>
        <h2 class="card-subtitle">Preencha os campos abaixo</h2>
        <br>
        <form action="${linkTo[ClienteController].update}" method="POST">
            <input type="hidden" name="cliente.id" value="${cliente.id}"/>
            <div class="form-group">
                <input class="form-label" type="text" name="cliente.nome" value="${cliente.nome}">
                <br>
                <input class="form-control" type="text" name="cliente.endereco" value="${cliente.endereco}">
            </div>
            <br>
            <div class="form-group">
                <input class="form-control" type="text" name="cliente.enderecoEntrega" value="${cliente.enderecoEntrega}">
                <br>
                <input class="form-control" type="text" name="cliente.cep" value="${cliente.cep}">
            </div>
            <br>
            <div class="form-group">
                <input class="form-control" type="text" name="cliente.contato" value="${cliente.contato}">
                <br>
                <input class="form-control" type="text" name="cliente.cpf" value="${cliente.cpf}">
                <br>
            </div>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="cidade" name="cliente.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
                <br>
                <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
