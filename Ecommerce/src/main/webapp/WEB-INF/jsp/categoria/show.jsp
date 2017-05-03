<%-- 
    Document   : show
    Created on : 03/05/2017, 15:14:45
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Categoria </title>
    </head>
    <body>
        <h1>Editando Categoria</h1>
        <form action="${linkTo[CategoriaController].update}" method="POST">
            <input type="hidden" name="categoria.id" value="${categoria.id}"/>
            <label for="categoria.descricao">Descricao</label> 
            </br>
            <input type="text" value="${categoria.descricao}" id="categoria.descricao" name="categoria.descricao">
            </br>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
