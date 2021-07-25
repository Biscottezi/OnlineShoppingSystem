/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import order.CustomizedOrderDTO;
import order.OrderDAO;
import order.OrderDTO;
import orderDetail.OrderDetailDAO;
import user.SaleMember;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SaleUpdateOrderServlet", urlPatterns = {"/SaleUpdateOrderServlet"})
public class SaleUpdateOrderServlet extends HttpServlet {

    private final String ERROR_PAGE = "error.html";
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
        SaleMember loggedin = (SaleMember)session.getAttribute("SALELOGIN");
        int loggedSaleID=0;
        if (loggedin!=null){
            loggedSaleID=loggedin.getId();
        }
        String urlRewriting=ERROR_PAGE;
        String id = request.getParameter("selectedOrderID");
        int orderID=0;
        if (id!=null && !id.isEmpty()){
            orderID=Integer.parseInt(id);
        }
        String salememID= request.getParameter("slSaleMem");
        int saleID;
        if (salememID!=null && !salememID.isEmpty()){
            saleID=Integer.parseInt(salememID);
        } else { 
            saleID=loggedSaleID;
        }
        String orderStatus= request.getParameter("slStatus");
        int status=0;
        if (orderStatus!=null && !orderStatus.isEmpty()){
            status=Integer.parseInt(orderStatus);
        }
        try {
            OrderDAO orderDAO = new OrderDAO();
            boolean result = orderDAO.updateOrderSale(orderID, status, saleID);
            if (result==true){
                urlRewriting = "SaleOrderDetailsServlet?orderId="+orderID;
                request.setAttribute("Announce","Order has been updated!");
                request.setAttribute("status",status);
                request.setAttribute("chosensale",saleID);
            }
        } catch (SQLException ex) {
            log("SaleUpdateOrderServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) { 
            log("SaleUpdateOrderServlet_NamingException: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(urlRewriting);
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
