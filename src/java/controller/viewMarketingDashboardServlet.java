/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import feedBack.FeedBackDAO;
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
import order.totalInOrderTable;
import post.PostDAO;
import product.ProductDAO;
import user.UserDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "viewMarketingDashboardServlet", urlPatterns = {"/viewMarketingDashboardServlet"})
public class viewMarketingDashboardServlet extends HttpServlet {
    private final String ERROR_PAGE="Error.html";
    private final String MARKETING_DASHBOARD="MarketingDashboard.jsp";
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
        
        String now = java.time.LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String monthago = java.time.LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String weekago = java.time.LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        
        HttpSession session = request.getSession(false);
        try{
            UserDAO userDAO = new UserDAO();
            int numOfCust = userDAO.getNoOfCustomerByMonth(now, monthago);
            session.setAttribute("CUSTOMERS", numOfCust);
            
            ProductDAO prodDAO = new ProductDAO();
            int numOfProd = prodDAO.getNoOfProductByMonth(now, monthago);
            session.setAttribute("PRODUCTS", numOfProd);
            
            PostDAO postDAO = new PostDAO();
            int numOfPost = postDAO.getNoOfPostByMonth(now, monthago);
            session.setAttribute("POSTS", numOfPost);
            
            FeedBackDAO feedDAO = new FeedBackDAO();
            int numOfFeed = feedDAO.getNoOfFeedbackByMonth();
            session.setAttribute("FEEDBACKS", numOfFeed);
            
            OrderDAO orderDAO = new OrderDAO();
            List<totalInOrderTable> graph = orderDAO.getMktGraphTotal(weekago, now);
            if(graph.size()>0){
                session.setAttribute("GRAPH", graph);
            }
            
            session.setAttribute("DATESTART", weekago);
            session.setAttribute("DATEEND", now);
            
            url = MARKETING_DASHBOARD;
        }
        catch(SQLException ex){
            log("viewMarketingDashboardServlet _ SQL:" + ex.getMessage());
        }
        catch(NamingException ex){
            log("viewMarketingDashboardServlet _ Naming:" + ex.getMessage());
        }
        finally{
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
