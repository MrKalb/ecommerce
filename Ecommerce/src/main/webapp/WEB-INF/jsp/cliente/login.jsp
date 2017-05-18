<%-- 
    Document   : login
    Created on : 17/05/2017, 14:50:40
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
        <h1>Bem Vindo !!</h1>
        <form action="${linkTo[ClienteController].authenticate}" method="POST">
            <input type="text" name="usuario.email" id="usuario.email" placeholder="Digite o email">
            <br>
            <input type="password" name="usuario.password" id="usuario.password" placeholder="Digite a senha">
            <br>
            <input type="submit" value="Enviar">
            
            <p>${mensagem}</p>
        </form>
    </body>
</html>
