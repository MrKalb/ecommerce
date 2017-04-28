<%-- 
    Document   : show
    Created on : 28/04/2017, 19:33:57
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizando - Estado ${estado.id}</title>
    </head>
    <body>
         <div class="content">
            <form action="${linkTo[EstadoController].update}" method="POST">
                <input type="hidden" name="estado.id" value="${estado.id}"/>
                <label for="estdescricao">Descricao</label>
                <br/>
                <input type="text" value="${estado.descricao}"  id="estname" name="estado.nome" size="50" placeholder="Informe o nome do Estado" />            
                <br/>
            </form>
         </div>
    </body>
</html>
