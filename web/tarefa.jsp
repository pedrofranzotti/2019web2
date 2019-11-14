<%-- 
    Document   : tarefa
    Created on : 06/11/2019, 22:10:11
    Author     : aluno
--%>

<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAOImpl"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="entidades.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <title>Tarefa</title>
    </head>
    <body>
<%
    Tarefa bean = new Tarefa();
    TarefaDAO dao = new TarefaDAOImpl();
    if(request.getParameter("descricao")!=null){
        bean.setDescricao(request.getParameter("descricao"));
        dao.save(bean);
        out.println("Tarefa salva com sucesso");
    } else if (request.getParameter("excluir") != null){
        int id = Integer.parseInt(request.getParameter("excluir"));
        dao.delete(dao.find(id));
    }
    List<Tarefa> lista = dao.list();
%>
        <h1>Tarefas</h1>
        <div class="container">
            <form action="tarefa.jsp">
                <div class="form-group row"> 
                    <div class="col-2">
                        <label form="descricao">Descrição</label>
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" name="descricao"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                        
                        
                </div>
            </form>
            <table>
                <thead>
                    <tr>
                        <th scope="col">
                            Descrição
                        </th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Tarefa t: lista){ %>
                    <tr>
                        <td><%= t.getDescricao() %></td>
                        <td>
                            <a href="tarefa.jsp?excluir=<%=t.getId()%>"><button class="btn btn-danger">Excluir</button>
                        </a>
                        </td>
                    </tr>
                    
                    
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
