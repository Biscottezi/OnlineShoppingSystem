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
import order.beforeRevenue;
import order.totalInOrderTable;
import user.SaleMember;
import user.UserDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "viewSManagerDashboardServlet", urlPatterns = {"/viewSManagerDashboardServlet"})
public class viewSManagerDashboardServlet extends HttpServlet {
    
    private final String SMANAGER_DASHBOARD = "SaleManagerDashboard.jsp";
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
            List<totalInOrderTable> graph = orderDao.getAdminGraphTotal(weekago, now);
            if(graph.size()>0){
                session.setAttribute("ORDERGRAPH", graph);
            }
            
            List<beforeRevenue> beforeRevenueList = orderDao.getBeforeRevenue();
            
            List<totalInOrderTable> revgraph = orderDao.getAdminGraphTotal(weekago, now);
            if(graph.size()>0){
                session.setAttribute("REVGRAPH", revgraph);
            }
            
            
            UserDAO userDao= new UserDAO();
            userDao.getSaleMembers();
            List<SaleMember> listsale = userDao.getSaleMemberList();
            session.setAttribute("SALELIST", listsale);
            
        } catch(SQLException ex){
            log("viewAdminDashboardServlet _ SQL:" + ex.getMessage());
        } catch(NamingException ex){
            log("viewAdminDashboardServlet _ Naming:" + ex.getMessage());
        } finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
