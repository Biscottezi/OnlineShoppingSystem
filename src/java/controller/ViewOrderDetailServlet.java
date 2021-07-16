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
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.CustomizedOrderDTO;
import order.OrderDAO;
import order.OrderDTO;
import orderDetail.OrderDetailDAO;
import orderDetail.OrderItemObj;
import product.ProductDAO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewOrderDetailServlet", urlPatterns = {"/ViewOrderDetailServlet"})
public class ViewOrderDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String DETAIL_LIST_PAGE = "CustomerOrderDetails.jsp";
    private final String ERROR_PAGE = "Error.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderID = request.getParameter("OrderID");
        String url = ERROR_PAGE;
        try {
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            
            OrderDAO dao1 = new OrderDAO();
            CustomizedOrderDTO order = dao1.getOrderByOrderId(Integer.parseInt(orderID));
            OrderDetailDAO dao2 = new OrderDetailDAO();
            order.setDetails(dao2.getOrderDetailsByOrderID(order.getOrderId()));
            if(order != null){
                request.setAttribute("ORDER_DETAIL", order);
            }
            
            url = DETAIL_LIST_PAGE;
        } catch (SQLException ex) {
            log("ViewOlderOrderDetailServlet SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewOlderOrderDetailServlet NamingException: " + ex.getMessage());
        } finally {
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
