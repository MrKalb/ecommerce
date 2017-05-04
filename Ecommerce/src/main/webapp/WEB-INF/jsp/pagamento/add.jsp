<%-- 
    Document   : add
    Created on : 04/05/2017, 14:30:42
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Formas de Pagamento</title>
    </head>
    <body>
        <h1>Cadastro de formas de Pagamento</h1>
        
        <form action="${linkTo[PagamentoController].adiciona}" method="POST">
            <input type="text" id="pagamento.descricao" name="pagamento.descricao" placeholder="Digite a descricao">
            <input type="submit" value="Salvar">
        
        </form>
    </body>
</html>
