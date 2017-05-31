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
            <p>"${produto.descricao}</p>
            <br>
            <p>${produto.vlrVenda}</p>
            <br>
            <input type="text" name="quantidade"  id="quantidade" placeholder="Quantidade">
            <br>
            <input type="submit" value="Continuar">
        </form>
    </body>
</html>
