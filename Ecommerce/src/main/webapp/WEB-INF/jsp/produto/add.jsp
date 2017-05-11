<%-- 
    Document   : add
    Created on : 10/05/2017, 15:07:28
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
        <h1>Adicionando produtos</h1>
        
        <form action="${linkTo[ProdutoController].adiciona}" method="POST">
        <input type="text" id="produto.descricao" name="produto.descricao" placeholder="Digite a descricao">  
        </br>
        <input type="text" id="vlrVenda" name="vlrVenda" placeholder="Digite o valor">
        </br>
        <input type="text" id="codBarras" name="codBarras" placeholder="Digite o codigo de barras">
        </br>
        <input type="submit" value="Salvar">
        </form>
    </body>
</html>
