<%-- 
    Document   : show
    Created on : 08/05/2017, 14:22:05
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
        <h1 class="card-title">Editando Transportadora</h1>
        <form action="${linkTo[TransportadoraController].update}" method="POST">
            <input type="hidden" name="transportadora.id" value="${transportadora.id}"/>
            <div class="form-group">
                <label class="form-label" for="transportadora.razao">Razao</label>            
            <br>
            <input class="form-control" type="text" value="${transportadora.razao}"  id="transportadora.razao" name="transportadora.razao"/>
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.fantasia">Fantasia</label>
            <br>
            <input class="form-control" type="text" value="${transportadora.fantasia}"  id="transportadora.fantasia" name="transportadora.fantasia"/>  
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.endereco">Endereco</label> 
            <br>
            <input class="form-control" type="text" value="${transportadora.endereco}"  id="transportadora.endereco" name="transportadora.endereco"/>     
            </div>
            <br>
            <div class="form-group">
                <label class="form-label" for="transportadora.cnpj">CNPJ</label>            
            <br>
            <input class="form-control" type="text" value="${transportadora.cnpj}"  id="transportadora.cnpj" name="transportadora.cnpj"/>     
            </div>
            <br>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="cidade" name="transportadora.cidade.id">
                <c:forEach items="${cidadeList}" var="cid">
                    <option value="${cid.id}">${cid.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <button class="btn btn-primary" type="submit">Salvar</button>

        </form>
    </body>
</html>
