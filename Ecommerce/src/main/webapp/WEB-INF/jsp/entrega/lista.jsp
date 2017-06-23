<%-- 
    Document   : lista
    Created on : 22/06/2017, 16:50:30
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
        <h1 class="card-title">Pedidos</h1>
        <table class="table-hover table-bordered">
            <tr>
                <th>#Id</th>
                <th>Numero Venda</th>
                <th>Numero Pedido</th>
                <th>Transportadora</th>
                <th>Status</th>
                <th>Açoes</th>
            </tr>
            
            <c:forEach items="${entregaList}" var="ent" varStatus="sts">
                <tr align="center">
                    <td>${ent.id}</td>
                    <td>${ent.idvenda}</td>
                    <td>${ent.numeroPedido}</td>
                    <td>${ent.transporte.razao}</td>
                    <td>${ent.status}</td>
                    <td><a href="${linkTo[EntregaController].show(ent)}">editar Status</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
