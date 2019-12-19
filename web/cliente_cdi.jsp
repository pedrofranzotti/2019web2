<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="aux" tagdir="/WEB-INF/tags"%>
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


        <div class="container">
            <form method="POST" action="cliente_cdi">

                <input type="hidden" class="form-control" name="id" type="text" required value="${cliente.id}"/>
                <div  class="form-group">
                    <label id="labelNome" for="label" > Nome: </label>
                    <input class="form-control" name="nome" type="text" required value="${cliente.nome}"/>
                </div>

                <div  class="form-group">
                    <label id="labelCPF" for="label"> CPF: </label>
                    <%-- <input class="form-control" name="cpf" type="text" required value="${cliente.cpf}"/>--%>
                    <aux:cpf classe="form-control" id="cpf" nome="cpf" valor="${cliente.cpf}"/> 
                </div>


                <div  class="form-group">
                    <label id="labelTelefone" for="label"> Telefone: </label>
                    <input class="form-control" name="telefone" type="text" required value="${cliente.telefone}"/>
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
                    <c:forEach var="c" items="${lista}">


                        <tr>
                            <td>${c.nome}</td>
                            <td>${c.cpf}</td>
                            <td>${c.telefone}</td>
                            <td> <a href="cliente_cdi?excluir=${c.id}"><button class="btn btn-danger">Excluir</button></a>
                                <a href="cliente_cdi?editar=${c.id}"><button class="btn btn-danger">Editar</button></a>
                            </td>
                            <%--<td> <a href="cliente?excluir=<%= c.getId()%>"><button class="btn btn-danger" onmouseover=document.getElementById("<%= c.getId()%>").>Excluir</button></a> </td>--%>
                        </tr>

                    </c:forEach>
                </tbody>


            </table>
        </div>
    </body>
</html>
