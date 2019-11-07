<%-- 
    Document   : hello
    Created on : 30/10/2019, 21:18:12
    Author     : aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <%
            List <Cliente> lista = (List <Cliente>) session.getAttribute("lista");
            if(lista == null){
                lista = new ArrayList <Cliente>();
            }
        %>
        
        <table class="table">
            <thead class="thead-dark">
                <tr>Nome</tr>
                <tr>CPF</tr>
            </thead>
            <tbody>
            <% for(Cliente c: lista){%>    
            
            <tr>
                <td><%= c.getNome() %></td>
                <td><%= c.getCpf() %></td>
            </tr>
            
            <% } %>
            </tbody>
                
            
        </table>
        
    </body>
</html>
