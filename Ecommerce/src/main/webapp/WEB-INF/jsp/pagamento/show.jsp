<%-- 
    Document   : show
    Created on : 04/05/2017, 14:41:19
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
        <h1 class="card-title">Editando Forma</h1>
        <c:import url="/WEB-INF/jsp/header.jsp"/>
        <form action="${linkTo[PagamentoController].update}" method="POST">
                <input type="hidden" name="pagamento.id" value="${formaPagamento.id}"/>
                <div class="form-control">
                <label class="form-label" for="pagamento.descricao">Descricao</label>
                <br>
                <input class="form-control" type="text" value="${formaPagamento.descricao}"  id="pagamento.descricao" name="pagamento.descricao"/>            
                </div>
                <br>
                <button class="btn btn-primary" type="submit">Salvar</button> 
            </form>
    </body>
</html>
