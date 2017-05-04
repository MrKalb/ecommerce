<%-- 
    Document   : list
    Created on : 04/05/2017, 14:35:05
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
        <h1>Lista de Formas de pagamento</h1>
        <table border="1">
            <tr>
                <th>#Id</th>
                <th>Descricao</th>
            </tr>
            <c:forEach items="${pagamentoList}" var="pag" varStatus="sts">
                <tr>
                    <td>${pag.id}</td>
                    <td>${pag.descricao}</td>
                    <td> <a href="${linkTo[PagamentoController].show(pag)}">Editar </a></td>
                    <td> <a href="${linkTo[PagamentoController].remove(pag)}" onclick="return confirm('Deseja realmente excluir ?')">Remover</a>;
                </tr>

            </c:forEach>
        </table>

    </body>
</html>
