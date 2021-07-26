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
import javax.swing.JOptionPane;
import order.OrderDAO;
import order.Revenue;
import order.beforeRevenue;
import order.totalInOrderTable;
import product.ProductDAO;
import product.averageRatedStar;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "viewAdminDashboardServlet", urlPatterns = {"/viewAdminDashboardServlet"})
public class viewAdminDashboardServlet extends HttpServlet {
    private final String ADMIN_DASHBOARD = "AdminDashboard.jsp";
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
            int submittedOrders = orderDao.getTotalOrderByStatus(0);
            
            session.setAttribute("SUBMITTED_ORDERS", submittedOrders);
            
            int confirmedOrders = orderDao.getTotalOrderByStatus(1);
            session.setAttribute("CONFIRMED_ORDERS", confirmedOrders);
            
            int shippedOrders = orderDao.getTotalOrderByStatus(2);
            session.setAttribute("SHIPPED_ORDERS", shippedOrders);
            
            int potentialCustomers = orderDao.getTotalPotentialCustomerByDate();
            session.setAttribute("POTENTIAL_CUSTOMERS", potentialCustomers);
            
            int customers = orderDao.getTotalCustomerByDate();
            session.setAttribute("CUSTOMERS", customers);
            
            List<totalInOrderTable> graph = orderDao.getAdminGraphTotal(weekago, now);
            if(graph.size()>0){
                session.setAttribute("GRAPH", graph);
            }
            session.setAttribute("DATESTART", weekago);
            session.setAttribute("DATEEND", now);
            
            ProductDAO productDao = new ProductDAO();
            List<averageRatedStar>ratedStarList = productDao.getAverageRatedStar();
            if(ratedStarList.size()>0){
                float avgRatedStar = 0;
                for(int i = 0; i < ratedStarList.size(); i++){
                    avgRatedStar += ratedStarList.get(i).getAverageStar();
                }
                averageRatedStar ratedStar = new averageRatedStar(avgRatedStar, 0);
                ratedStarList.add(ratedStar);
                session.setAttribute("RATED_STAR_LIST", ratedStarList);
            }
            
            List<beforeRevenue> beforeRevenueList = orderDao.getBeforeRevenue();
            if(beforeRevenueList.size()>0){
                List<Revenue> revenueList = new ArrayList<>();
                for(int i=0; i < beforeRevenueList.size(); i++){
                    if(beforeRevenueList.get(i).getSalePrice() == 0){
                        Revenue revenue = new Revenue(beforeRevenueList.get(i).getListPrice(), beforeRevenueList.get(i).getDate(), beforeRevenueList.get(i).getCategoryID());
                        revenueList.add(revenue);
                    }else{
                        Revenue revenue = new Revenue(beforeRevenueList.get(i).getSalePrice(), beforeRevenueList.get(i).getDate(), beforeRevenueList.get(i).getCategoryID());
                        revenueList.add(revenue);
                    }
                }
                session.setAttribute("REVENUE", revenueList);
            }
            
            url = ADMIN_DASHBOARD;
        }catch(SQLException ex){
            log("viewAdminDashboardServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("viewAdminDashboardServlet _ Naming:" + ex.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
