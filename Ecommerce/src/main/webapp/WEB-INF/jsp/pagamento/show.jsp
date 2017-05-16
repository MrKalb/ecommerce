<%-- 
    Document   : show
    Created on : 04/05/2017, 14:41:19
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
        <h1>Editando Forma</h1>
        <form action="${linkTo[PagamentoController].update}" method="POST">
                <input type="hidden" name="pagamento.id" value="${formaPagamento.id}"/>
                <label for="pagamento.descricao">Descricao</label>
                <br>
                <input type="text" value="${formaPagamento.descricao}"  id="pagamento.descricao" name="pagamento.descricao"/>            
                <br>
                <input type="submit" value="salvar"> 
            </form>
    </body>
</html>
