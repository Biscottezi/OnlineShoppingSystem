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
import java.util.List;
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
@WebServlet(name = "ViewSaleOrderListServlet", urlPatterns = {"/ViewSaleOrderListServlet"})
public class ViewSaleOrderListServlet extends HttpServlet {

     private final String SALE_ORDER_LIST_PAGE = "SaleMemberOrders.jsp";
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
        int saleID=0;
        if (loggedin!=null){
            saleID=loggedin.getId();
        }
        String url = SALE_ORDER_LIST_PAGE;
        try {
            OrderDAO orderDAO = new OrderDAO();
            List<CustomizedOrderDTO> orderList = orderDAO.getAllOrderListbySaleID(saleID);
            for(int i = 0; i < orderList.size(); ++i){
                OrderDetailDAO orderDetDAO = new OrderDetailDAO();
                int orderId = orderList.get(i).getOrderId();
                orderList.get(i).setDetails(orderDetDAO.getOrderDetailsByOrderID(orderId));
            }
            request.setAttribute("ORDERLIST", orderList);
            url = SALE_ORDER_LIST_PAGE;
           
        } catch (SQLException ex) {
          log("ViewSaleOrderListServlet SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
          log("ViewSaleOrderListServlet NamingException: " + ex.getMessage());
        }
        finally {
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
