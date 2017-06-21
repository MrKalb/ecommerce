<%-- 
    Document   : lista
    Created on : 21/06/2017, 10:59:49
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Listagem de Produtos por categoria</h1>
        <table border="1">
            <tr> 
                <th>Nome</th>
                <th>Tipo</th>
            </tr>
            <c:forEach items="${listaList}" var="tip" varStatus="sts">
                <tr>
                    <td>${tip.descricao}</td>
                    <td>${tip.categoria}</td>
                    <td> <a href="${linkTo[AdicionaController].removeItem(tip, tip.categoria.id)}">Remover</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
