/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import order.OrderDAO;
import order.totalInOrderTable;

/**
 *
 * @author nguye
 */
@WebServlet(name = "changeMktGraphServlet", urlPatterns = {"/changeMktGraphServlet"})
public class changeMktGraphServlet extends HttpServlet {

    private final String MKT_PAGE = "";
    private final String ERROR_PAGE = "";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        String url = ERROR_PAGE;
        String daterange = request.getParameter("daterange");
        String[] date = daterange.split(" - ");
        String start = date[0];
        String end = date[1];
        
        try {
            OrderDAO orderdao = new OrderDAO();
            List<totalInOrderTable> graph = orderdao.getMktGraphTotal(start, end);
            session.setAttribute("GRAPH", graph);
            session.setAttribute("DATESTART", start);
            session.setAttribute("DATEEND", end);
            url = MKT_PAGE;
        }
        catch(SQLException ex){
            log("changeMktGraphServlet _ SQL:" + ex.getMessage());
        }
        catch(NamingException ex){
            log("changeMktGraphServlet _ Naming:" + ex.getMessage());
        }
        finally{
            response.sendRedirect(url);
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
