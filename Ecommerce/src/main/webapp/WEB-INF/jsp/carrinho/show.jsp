<%-- 
    Document   : show
    Created on : 29/05/2017, 20:13:54
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
        <h1>Carrinho</h1>
        <form action="${linkTo[CarrinhoController].adicionaCarrinho}" method="POST">
        <input type="hidden" name="produto.id" value="${produto.id}"/>
            <br>
            <input type="text" name="produto.descricao" value="${produto.descricao}" id="produto.descricao">
            <br>
            <input type="text" name="produto.vlrVenda" value="${produto.vlrVenda}" id="produto.vlrVenda">
            <br>
            <input type="text" name="quantidade"  id="quantidade" placeholder="Quantidade">
            <br>
            <input type="submit" value="Continuar">
        </form>
    </body>
</html>
