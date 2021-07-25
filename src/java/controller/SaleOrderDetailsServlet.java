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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.CustomizedOrderDTO;
import order.OrderDAO;
import orderDetail.OrderDetailDAO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SaleOrderDetailsServlet", urlPatterns = {"/SaleOrderDetailsServlet"})
public class SaleOrderDetailsServlet extends HttpServlet {

    private final String ORDER_DETAILS_PAGE = "SaleOrderDetails.jsp";
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
        String id = request.getParameter("orderId");
        int orderID=0;
        if (id!=null && !id.isEmpty()){
            orderID=Integer.parseInt(id);
        }
        try {
            OrderDAO orderDAO = new OrderDAO();
            
            //get order
            CustomizedOrderDTO order = orderDAO.getSaleOrderByOrderId(orderID);
            
            //get order details
            OrderDetailDAO orderDetDAO = new OrderDetailDAO();
            int orderId = order.getOrderId();
            order.setDetails(orderDetDAO.getOrderDetailsByOrderID(orderId));
            //get customer details
            UserDAO userDAO = new UserDAO();
            userDAO.getUserByID(order.getCustomerId());
            UserDTO customer = userDAO.getUser();
            order.setCustomer(customer);
            request.setAttribute("ORDER", order);
            
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            
            url = ORDER_DETAILS_PAGE;
        } catch (SQLException ex) {
          log("ViewSaleOrderListServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
          log("ViewSaleOrderListServlet_NamingException: " + ex.getMessage());
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
