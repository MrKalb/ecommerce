<%-- 
    Document   : add
    Created on : 16/05/2017, 10:28:00
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="${linkTo[ClienteController].add}" method="POST">
            <input type="text" id="cliente.nome" name="cliente.nome" placeholder="Nome Completo"
        
        </form>
    </body>
</html>
