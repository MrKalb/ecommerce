<%-- 
    Document   : list
    Created on : 22/06/2017, 17:45:01
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
        <h1>Carrinho</h1>
        <table class="table-hover">
            <tr>
                <th>Descricao</th>
                <th>Valor Venda</th>
                <th>Quantidade</th>
            </tr>
            
            <c:forEach items="${vendaList}" var="v" varStatus="sts">
                <tr align="center">
                    
                    <td>${v.produto.descricao}</td>
                    <td>${v.produto.vlrVenda}</td>
                    <td>${v.quantidade}</td>
                </tr>
            </c:forEach>
        </table>
                <div>
                    <label>Preco Final</label>
                    <br>
                    <label>${preco}</label>
                </div>
    </body>
</html>
