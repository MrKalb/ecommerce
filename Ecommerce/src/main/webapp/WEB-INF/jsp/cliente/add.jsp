<%-- 
    Document   : add
    Created on : 16/05/2017, 10:28:00
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
        <h1 class="card-title">Bem vindo !! </h1>
        <br>
        <h2 class="card-subtitle">Preencha os campos abaixo</h2>
        <br>
        <form action="${linkTo[ClienteController].adiciona}" method="POST">
            <div class="form-group">
                <input class="form-label" type="text" id="cliente.nome" name="cliente.nome" placeholder="Nome Completo">
            <br>
            <input class="form-control" type="text" id="cliente.endereco" name="cliente.endereco" placeholder="Endereco">
            </div>
            <br>
            <div class="form-group">
                <input class="form-control" type="text" id="cliente.enderecoEntrega" name="cliente.enderecoEntrega" placeholder="Endereco de Entrega">
            <br>
            <input class="form-control" type="text" id="cliente.cep" name="cliente.cep" placeholder="CEP">
            </div>
            <br>
            <div class="form-group">
                <input class="form-control" type="text" id="cliente.contato" name="cliente.contato" placeholder="Contato">
            <br>
            <input class="form-control" type="text" id="cliente.cpf" name="cliente.cpf" placeholder="CPF">
            <br>
            </div>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="cidade" name="cliente.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <div class="form-group">
                <input class="form-control" type="text" id="usuario.email" name="usuario.email" placeholder="Email">
            <br>
            <input class="form-control" type="password" id="usuario.password" name="usuario.password" placeholder="senha">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>
        </form>
    </body>
</html>
