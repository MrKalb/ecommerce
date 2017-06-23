<%-- 
    Document   : login
    Created on : 17/05/2017, 14:50:40
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
        <h1 class="card-title text-center">Bem Vindo !!</h1>
        <div class="container" style="width: 300px">
            <div class="card card-container">
                <img class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"/>
                <p class="profile-name-card"></p>
                <form class="form-signin" action="${linkTo[ClienteController].authenticate}" method="POST">
                    <input class="form-control" type="email" name="usuario.email" id="usuario.email" placeholder="Digite o email">
                    <br>
                    <input class="form-control" type="password" name="usuario.password" id="usuario.password" placeholder="Digite a senha">
                    <br>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="btn-01">Entrar</button> 
                    <br>
                </form>
            </div>
            <div class="card-footer">
                <a href="${linkTo[ClienteController].adiciona}">Novo ? </a>
            </div>
        </div>
        <script>
            function $(id) {
                var el = document.getElementById(id);
                if (!el) {
                    el = document.createElement('div');
                    el.setAttribute('id', id);
                    document.body.insertAdjacentElement('beforeEnd', el);
                }
                return el;
            }

         //   $('btn-01').addEventListener('click', function () {
              //  window.location.replace("produto/lista");

            //});
        </script>
    </body>
</html>
