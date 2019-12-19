/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import cdi.Auditavel;
import cdi.DAOQualifier;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */

@WebServlet(name = "ClienteCDIServlet", urlPatterns = {"/cliente_cdi"})
public class ClienteCDIServlet extends HttpServlet {
    
    @Inject
    private Cliente c;
    
    @Inject
    private ClienteDAO dao;
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Auditavel
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Chamou");
        
        if(request.getParameter("nome")!= null){
            if (!request.getParameter("id").equals("")){
                int id = Integer.parseInt(request.getParameter("id"));
                c.setId(id);
            }
            c.setNome(request.getParameter("nome"));
            c.setCpf(request.getParameter("cpf"));
            c.setTelefone(request.getParameter("telefone"));
            dao.save(c);
        } else if(request.getParameter("excluir")!= null){
            int id = Integer.parseInt(request.getParameter("excluir"));
            dao.delete(dao.find(id));
        } else if(request.getParameter("editar")!= null){
            int id = Integer.parseInt(request.getParameter("editar"));
            request.setAttribute("cliente", dao.find(id));
        }
        System.out.println(request.getParameter("nome"));
        request.setAttribute("lista", dao.list());
        
        RequestDispatcher view = request.getRequestDispatcher("cliente_cdi.jsp");
        view.forward(request, response);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteJSTLServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteJSTLServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}