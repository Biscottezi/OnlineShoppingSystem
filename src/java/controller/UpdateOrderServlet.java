/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.Cart;
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
import javax.servlet.http.HttpSession;
import order.OrderDAO;
import order.OrderDTO;
import orderDetail.OrderDetailDAO;
import orderDetail.OrderDetailDTO;
import orderDetail.OrderItemObj;
import product.ProductDAO;
import product.ProductDTO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/UpdateOrderServlet"})
public class UpdateOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String CART_DETAILS_UPDATE = "CartDetailsUpdate.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String custId = request.getParameter("CustomerID");
        String selectedOrderID = request.getParameter("orderID");
        String url = CART_DETAILS_UPDATE;
        try {
            HttpSession session = request.getSession(true);
            
            Cart cart = new Cart();
            
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                session.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            
            OrderDAO orderdao = new OrderDAO();
            OrderDTO orderdto = orderdao.getOrderDTOByOrderID(Integer.parseInt(selectedOrderID));
            session.setAttribute("ORDER", orderdto);
            
            OrderDetailDAO detaildao = new OrderDetailDAO();
            List<OrderDetailDTO> detailList = detaildao.getDetailsByOrderID(Integer.parseInt(selectedOrderID));
            for(int i = 0; i < detailList.size(); ++i){
                int prodID = detailList.get(i).getProductId();
                int quantity = detailList.get(i).getQuantity();
                cart.addToCart(prodID, quantity);
            }
            
            session.setAttribute("CART", cart);
            
        }
        catch (SQLException ex) {
            log("UpdateOrderServlet SQLException: " + ex.getMessage());
        }
        catch (NamingException ex) { 
            log("UpdateOrderServlet NamingException: " + ex.getMessage());
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
