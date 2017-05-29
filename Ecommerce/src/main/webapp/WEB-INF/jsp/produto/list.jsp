<%-- 
    Document   : list
    Created on : 10/05/2017, 15:24:07
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lujinha</title>
    </head>
    <body>
        <h1>Listagem de Produto</h1>
        <table border="1">
            <tr>
                <th>#Id</th>
                <th>Descricao</th>
                <th>Valor</th>
                <th>CodBarras</th>
                <th>Açoes</th>
            </tr>
            
            <c:forEach items="${produtoList}" var="prod" varStatus="sts">
                <tr>
                <td>${prod.id}</td>
                <td>${prod.descricao}</td>
                <td>${prod.vlrVenda}</td>
                <td>${prod.codBarras}</td>
                <td> <a href="${linkTo[AdicionaController].show(prod)}">Adicionar Categoria</a>
                <td> <a href="${linkTo[ProdutoController].show(prod)}">Editar Produto</a></td>
                <td> <a href="${linkTo[CarrinhoController].show(prod)}">Adicionar a carrinho</a></td>
                <td> <a href="${linkTo[ProdutoController].remove(prod)}" onclick="return confirm('Deseja realmente excluir ?')">Remover</a>;
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
