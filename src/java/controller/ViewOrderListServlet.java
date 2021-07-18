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
import order.CustomizedOrderDTO;
import order.OrderDAO;
import order.OrderDTO;
import orderDetail.OrderDetailDAO;
import orderDetail.OrderDetailDTO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewOrderListServlet", urlPatterns = {"/ViewOrderListServlet"})
public class ViewOrderListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private final String ORDER_LIST_PAGE = "CustomerOrderList.jsp";
     private final String ERROR_PAGE = "Error.html";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String custId = request.getParameter("customerID"); 
        String url = ERROR_PAGE;
        
        try{
            OrderDAO dao1 = new OrderDAO();
            List<CustomizedOrderDTO> orders = dao1.getOrderListByCustomer(Integer.parseInt(custId));
            for(int i = 0; i < orders.size(); ++i){
                OrderDetailDAO dao2 = new OrderDetailDAO();
                int orderId = orders.get(i).getOrderId();
                orders.get(i).setDetails(dao2.getOrderDetailsByOrderID(orderId));
            }
            if(orders != null){
                request.setAttribute("ORDER_LIST", orders);
            }
            
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            
            url = ORDER_LIST_PAGE;
        }
        catch(SQLException ex){
            log("ViewOrderListServlet_SQL: " + ex.getMessage());
        }
        catch(NamingException ex){
            log("ViewOrderListServlet_Naming: " + ex.getMessage());
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
