/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import order.OrderDAO;
import order.totalInOrderTable;
import org.eclipse.jdt.core.compiler.InvalidInputException;

/**
 *
 * @author Admin
 */
@WebServlet(name = "changeAdminGraphServlet", urlPatterns = {"/changeAdminGraphServlet"})
public class changeAdminGraphServlet extends HttpServlet {

    private final String ADMIN_PAGE = "AdminDashboard";
    private final String ERROR_PAGE = "viewAdminDashboardServlet";
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
        int status=0;
        String daterange = request.getParameter("daterange");
        if (!request.getParameter("graphstatus").isEmpty()) {
        status = Integer.parseInt(request.getParameter("graphstatus"));
        }
        String[] date = daterange.split(" - ");
        String start = date[0];
        String end = date[1];
        try {
            OrderDAO orderdao = new OrderDAO();
            List<totalInOrderTable> graph;
            if (status>0) graph = orderdao.getAdminGraphShipped(start, end, status);
            else graph = orderdao.getAdminGraphTotal(start, end);
            session.setAttribute("GRAPH", graph);
            session.setAttribute("DATESTART", start);
            session.setAttribute("DATEEND", end);
            session.setAttribute("STATUS", status);
            url=ADMIN_PAGE;
        }
        catch(SQLException ex){
            log("changeAdminGraphServlet _ SQL:" + ex.getMessage());
        }
        catch(NamingException ex){
            log("changeAdminGraphServlet _ Naming:" + ex.getMessage());
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
