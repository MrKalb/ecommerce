<%-- 
    Document   : add
    Created on : 11/05/2017, 14:57:52
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
        <h1>Hello World!</h1>
        <div style="display: inline;float: left; margin: 20px;">
            <form method="POST" action="${linkTo[AdicionaController].adicionaCategoria}">
                <fieldset>
                    <legend>Adicionar Item ao Estoque</legend>
                    <label for="produtos">Escolha o produto</label>
                    <br/>
                    <select id="produtos" name="produtoId">
                        <c:forEach items="${produtoList}" var="prd">
                            <option value="${prd.id}">${prd.nome}</option>                                
                        </c:forEach>                            
                    </select>
                    <br/>
                    <br/>
                    <select id="categoria" name="categoriaId">
                        <c:forEach items="${categoriaList}" var="cat">
                            <option value="${cat.id}">${cat.nome}</option>                                
                        </c:forEach>                            
                    </select>                      
                    <br/>
                    <br/>
                    <input type="submit" value="Adicionar"/>

                </fieldset>                    

            </form>
            <br/>
            <table border="1" style="width: 60%;">        
                <tr>
                    <th>#Id</th>
                    <th>Nome Produto</th>                    
                    <th>Categoria</th>                    
                    <th>Ações </th>

                </tr>
                <c:forEach items="${produto.categoria}" var="cat" varStatus="sts">
                    <tr align="center" bgcolor="${sts.count % 2 == 0 ? 'ffff00' : 'ffffff' }">
                        <td>${cat.id} </td>    
                        <td>${cat.descricao} </td>                        
                        <td>${cat.categoria.descricao} </td>                        
                        <td>
                            <a href="${linkTo[AdicionaController].removeItem(produto,cat)}" onclick="return confirm('Deseja realmente excluir o item?')">Remover</a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
