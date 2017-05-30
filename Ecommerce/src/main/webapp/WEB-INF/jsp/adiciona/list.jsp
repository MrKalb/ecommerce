<%-- 
    Document   : list
    Created on : 30/05/2017, 16:49:13
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
        <h1>Listagem de Produtos por categoria</h1>
        <table border="1">
            <tr> 
                <th>Nome</th>
                <th>Tipo</th>
                <th>Valor</th>
            </tr>
            <c:forEach items="${tipoList}" var="tip" varStatus="sts">
                <tr>
                    <td>${tip.produto.descricao}</td>
                    <td>${tip.categoria.descricao}</td>
                    <td>${tip.produto.vlrvenda}</td>
                    <td> <a href="${linkTo[CarrinhoController].show(tip.produto)}">Adicionar a carrinho</a></td>
                </tr>
            </c:forEach>
                <a href="${linkTo[ProdutoController].list}">Voltar para listagem de produtos</a>
        </table>
        
    </body>
</html>
