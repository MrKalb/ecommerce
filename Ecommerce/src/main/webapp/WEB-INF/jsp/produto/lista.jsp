<%-- 
    Document   : lista
    Created on : 19/06/2017, 16:10:15
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lujinha</title>
        <c:import url="/WEB-INF/jsp/head.jsp"/>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/nav.jsp"/>
        <h1 class="card-title">Lujinha</h1>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Descricao</th>
                    <th>Valor</th>
                    <th>Açoes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtoList}" var="prod" varStatus="sts">
                    <tr>
                        <td>${prod.descricao}</td>
                        <td>${prod.vlrVenda}</td>
                        <td><a href="${linkTo[CarrinhoController].show(prod)}">Adicionar a carrinho</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form class="form-control" action="${linkTo[AdicionaController].list}" method="POST">
            <br>
            <h2 class="card-subtitle">Pesquisa de produtos por Categoria</h2> 
            <br>
            <input class="card-text" type="text" id="tipo" name="tipo" placeholder="Digite a categoria desejada">
            <input class="card-text" type="submit" value="Pesquisar">
            <br>
        </form>
    </body>
</html>
