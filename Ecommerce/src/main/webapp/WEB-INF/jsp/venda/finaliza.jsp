<%-- 
    Document   : finaliza
    Created on : 07/06/2017, 10:25:12
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
    <body class="align-contend center">
        <h1 class="card-title">Finalizando Venda</h1>
        <c:import url="/WEB-INF/jsp/nav.jsp"/>
        <form action="${linkTo[VendaController].finalizaVenda}" method="POST">
            <input type="hidden" name="carrinho.id" value="${carrinho.id}"/>
            <table class="table-hover table-bordered">
                <h2 class="card-subtitle">Produtos</h2>
                <tr>
                    <th>Produto</th>
                    <th>Valor</th>
                </tr>
                <br>
                <c:forEach items="${itemList}" var="item" varStatus="sts">
                    <tr>
                        <td>${item.produto.descricao}</td>
                        <td>${item.produto.vlrVenda}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <label class="form-label">Transportadora</label>
            <br>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="transportadora" name="venda.transportadora.id">
                <c:forEach items="${transpList}" var="tr" varStatus="sts">                    
                    <option value="${tr.id}">${tr.razao}</option>
                </c:forEach>
            </select>
            <br>
            <label class="form-label">Forma de Pagamento</label>
            <br/>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="formapagamento" name="venda.forma.id">
                <c:forEach items="${formaList}" var="fp" varStatus="sts">                    
                    <option value="${fp.id}">${fp.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <div class="card-text">
                Frete ${frete}
            </div>
            <div class="card-footer">
                Total ${total} 
            </div>
            <button class="btn btn-primary" type="submit">Confirmar</button>
        </form>
    </body>
</html>
