<%-- 
    Document   : index
    Created on : 26/04/2017, 10:14:07
    Author     : igor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="${linkTo[EstadoController].add}">Criar estado</a>
    </body>
</html>
