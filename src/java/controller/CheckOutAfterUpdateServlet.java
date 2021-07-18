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
import java.util.Map;
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
import order.OrderDAO;
import orderDetail.OrderDetailDAO;
import product.ProductDTO;
import user.UserDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CheckOutAfterUpdateServlet", urlPatterns = {"/CheckOutAfterUpdateServlet"})
public class CheckOutAfterUpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCCESS_PAGE = "CartCompletion.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String OrderID = request.getParameter("OrderID");
        String Receivername = request.getParameter("txtReceiverName");
        String Receivergender = request.getParameter("txtReceiverGender");
        String email = request.getParameter("txtReceiverEmail");
        String phone = request.getParameter("txtReceiverMobile");
        String address = request.getParameter("txtReceiverAddress");
        String note = request.getParameter("txtNote");
        HttpSession session = request.getSession();
        String url = SUCCESS_PAGE;
        try {         

            
            if (session != null) {
                //2.Take customer's cart
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    Map<Integer,ProductDTO> items = cart.getItems();
                    if (items != null) {
                        //3.Create order                                            
                         OrderDAO orderDAO = new OrderDAO();
                        orderDAO.updateOrder( Integer.parseInt(OrderID),Receivername, Integer.parseInt(Receivergender), address, email, phone);
                        //4.Get each item and add to order
                        OrderDetailDAO detailDAO = new OrderDetailDAO();
                        ProductDTO dto =new ProductDTO();
                        
                        for (int ID : items.keySet()) {
                            int quantity = dto.getQuantity();
                            detailDAO.CreateOrderDetail(Integer.parseInt(OrderID), ID, quantity);
                        }//end for items.keySet
                    }//end if items is not null  
                    session.removeAttribute("CART");
                }//end if cart is not null
            }//end if session is not null
        } catch (SQLException ex) {
            log(" CheckoutServlet SQLException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log(" CheckoutServlet SQLException " + ex.getMessage());
        } catch (NamingException ex) {
            log(" CheckoutServlet NamingException " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(SUCCESS_PAGE);
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
