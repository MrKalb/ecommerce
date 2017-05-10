<%-- 
    Document   : show
    Created on : 10/05/2017, 15:35:44
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
        <h1>Editando Produto</h1>
        <form action="${linkTo[ProdutoController].update}" method="POST">
        <input type="hidden" name="produto.id" value="${produto.id}"/>
        </br>
        <label for="produto.descricao">Descricao</label>
        </br>
        <input type="text" name="produto.descricao" value="${produto.descricao}" id="produto.descricao">
        </br>
        <label for="produto.vlrVenda">Valor</label>
        </br>
        <input type="text" name="produto.vlrVenda" value="${produto.vlrVenda}" id="produto.vlrVenda">
        </br>
        <label for="produto.codBarras">Valor</label>
        </br>
        <input type="text" name="produto.codBarras" value="${produto.codBarras}" id="produto.codBarras">
        </br>
        <input type="submit" value="salvar">
        </form>
        
    </body>
</html>
