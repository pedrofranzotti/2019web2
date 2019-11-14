<%-- 
    Document   : cliente
    Created on : 13/11/2019, 21:42:52
    Author     : aluno
--%>

<%@page import="java.util.List"%>
<%@page import="entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cliente</h1>
        <%
            int id =0;
            String nome="";
            String telefone ="";
            String cpf = "";
            if (request.getAttribute("cliente")!=null){
                Cliente ed = (Cliente) request.getAttribute("cliente");
                id = ed.getId();
                nome = ed.getNome();
                telefone = ed.getTelefone();
                cpf = ed.getCpf();
            }


        %>
        
        <div class="container">
            <form method="POST" action="./cliente">
                
                <input hidden class="form-control" name="id" type="text" required value="<%= id %>"/>
            <div id="formulario" class="form-group">
                <label id="labelNome" for="label" > Nome: </label>
                <input class="form-control" name="nome" type="text" required value="<%= nome %>"/>
            </div>
            
            <div id="formulario" class="form-group">
                <label id="labelCPF" for="label"> CPF: </label>
                <input class="form-control" name="cpf" type="text" value="<%= cpf %>" required/>
            </div>

            
            <div id="formulario" class="form-group">
                <label id="labelTelefone" for="label"> Telefone: </label>
                <input class="form-control" name="telefone" type="text" required value="<%= telefone %>"/>
            </div>

            <button id="salvar" class="btn btn-primary" type="submit">Enviar</button>
                
                
        </form>
        </div>
        
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Ação</th>
                    </tr>

                </thead>
                <tbody  class="tbody-dark">
                    <% List<Cliente> lista;
                       lista = (List<Cliente>) request.getAttribute("lista");
                    
                %>
                    <% for(Cliente c: lista){%>    
 
                <tr id="<%= c.getId() %>">
                    <td ><%= c.getNome() %></td>
                    <td><%= c.getCpf() %></td>
                    <td><%= c.getTelefone() %></td>
                    <td> <a href="cliente?excluir=<%= c.getId()%>"><button class="btn btn-danger">Excluir</button></a>
                         <a href="cliente?editar=<%= c.getId()%>"><button class="btn btn-danger">Editar</button></a>
                    </td>
                    <%--<td> <a href="cliente?excluir=<%= c.getId()%>"><button class="btn btn-danger" onmouseover=document.getElementById("<%= c.getId()%>").>Excluir</button></a> </td>--%>
                </tr>

                <% } %>
                </tbody>


            </table>
        </div>
    </body>
</html>
