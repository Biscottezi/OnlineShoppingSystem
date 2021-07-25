/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import order.OrderDAO;
import order.Revenue;
import order.totalInOrderTable;
import user.SaleMember;
import user.UserDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "viewSManagerDashboardServlet", urlPatterns = {"/viewSManagerDashboardServlet"})
public class viewSManagerDashboardServlet extends HttpServlet {
    
    private final String SMANAGER_DASHBOARD = "SaleManagerDashboard";
    private final String ERROR_PAGE = "Error.html";
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
        String url = ERROR_PAGE;
        String now = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String weekago = java.time.LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        HttpSession session = request.getSession(false);
        
        try {
            OrderDAO orderDao = new OrderDAO();
            List<totalInOrderTable> graph = orderDao.getSaleGraphTotal(weekago, now);
            session.setAttribute("ORDERGRAPH", graph);
            
            
            List<Revenue> revenueList = orderDao.getTotalRevenuebyDate(weekago,now);
            session.setAttribute("REVGRAPH", revenueList);
            
            UserDAO userDao= new UserDAO();
            userDao.getSaleMembers();
            List<SaleMember> listsale = userDao.getSaleMemberList();
            session.setAttribute("SALELIST", listsale);
            session.setAttribute("DATESTART", weekago);
            session.setAttribute("DATEEND", now);
            url= SMANAGER_DASHBOARD;
        } catch(SQLException ex){
            log("viewSManagerDashboardServlet_SQL:" + ex.getMessage());
        } catch(NamingException ex){
            log("viewSManagerDashboardServlet_Naming:" + ex.getMessage());
        } finally{
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
