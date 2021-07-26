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
import java.util.Map;
import java.util.Random;
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
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;
import user.UserDAO;
import user.UserDTO;
import utils.sendMail;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {

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
        //String custId = request.getParameter("custId");
        String Receivername = request.getParameter("txtReceiverName");
        String Receivergender = request.getParameter("txtReceiverGender");
        String email = request.getParameter("txtReceiverEmail");
        String phone = request.getParameter("txtReceiverMobile");
        String address = request.getParameter("txtReceiverAddress");
        String note = request.getParameter("txtNote");
        HttpSession session = request.getSession();
        String url = SUCCESS_PAGE;
        try {
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            if (session != null) {
                //2.Take customer's cart
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    Map<Integer,ProductDTO> items = cart.getItems();
                    if (items != null) {
                        //3.Create order
                        UserDAO dao= new UserDAO();
                        List<Integer> saleActive = dao.getSaleMemberActive();
                        Random rand = new Random();
                        int saleID = saleActive.get(rand.nextInt(saleActive.size()));
                        OrderDAO orderDAO = new OrderDAO();
                        int newOrderID;
                        if(session.getAttribute("custId") != null){
                            int custId = (int) session.getAttribute("custId");
                            newOrderID = orderDAO.CreateOrder(custId, Receivername, Integer.parseInt(Receivergender), address, email, phone, note, saleID);
                        }
                        else{
                            newOrderID = orderDAO.CreateOrderGuest( Receivername, Integer.parseInt(Receivergender), address, email, phone, note, saleID);
                        }
                        //4.Get each item and add to order
                        OrderDetailDAO detailDAO = new OrderDetailDAO();
                        for (int ID : items.keySet()) {
                            int quantity = items.get(ID).getQuantity();
                            detailDAO.CreateOrderDetail(newOrderID, ID, quantity);
                        }//end for items.keySet
                        sendMail.mailCheckout(email, newOrderID);
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
