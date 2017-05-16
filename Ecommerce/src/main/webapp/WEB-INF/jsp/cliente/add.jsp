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
    </head>
    <body>
        <h1>Bem vindo !! </h1>
        <br>
        <h2>Preencha os campos abaixo</h2>
        <br>
        <form action="${linkTo[ClienteController].adiciona}" method="POST">
            <input type="text" id="cliente.nome" name="cliente.nome" placeholder="Nome Completo">
            <br>
            <input type="text" id="cliente.endereco" name="cliente.endereco" placeholder="Endereco">
            <br>
            <input type="text" id="cliente.enderecoEntrega" name="cliente.enderecoEntrega" placeholder="Endereco de Entrega">
            <br>
            <input type="text" id="cliente.cep" name="cliente.cep" placeholder="CEP">
            <br>
            <input type="text" id="cliente.contato" name="cliente.contato" placeholder="Contato">
            <br>
            <input type="text" id="cliente.cpf" name="cliente.cpf" placeholder="CPF">
            <br>
            <select id="cidade" name="cliente.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
            <br>
        </form>
            <br>
            <br>
            <br>
            <form action="${linkTo[ClienteController].createUsuario}" method="POST">
                <input type="text" id="usuario.email" placeholder="Email">
                <br>
                <input type="password" id="usuario.password" placeholder="senha">
                <br>
                <input type="submit" value="Salvar">
            </form>
    </body>
</html>
