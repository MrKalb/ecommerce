<%-- 
    Document   : add
    Created on : 03/05/2017, 15:01:41
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionando Categoria</title>
    </head>
    <body>
        <h1>Adicionando Categoria!</h1>
        
        <form action="${linkTo[CategoriaController].adiciona}" method="POST">
            
            <input type="text" id="categoria.descricao" name="categoria.descricao" placeholder="Digite a descricao da categoria">
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
