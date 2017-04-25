<%-- 
    Document   : adiciona
    Created on : 25/04/2017, 11:28:07
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionando Estado!</h1>
        <form action="${linkTo[EstadoController].adiciona}" method="POST" >
            Descricao <input type="text" name="descricao.estado">
            <input type="submit" value="salvar"> 
        </form>
    </body>
</html>
