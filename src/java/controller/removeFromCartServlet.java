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
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "removeFromCartServlet", urlPatterns = {"/removeFromCartServlet"})
public class removeFromCartServlet extends HttpServlet {
    private final String ERROR = "error";
    private final String CART_DETAILS = "CartDetails";
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
        String url = ERROR;
        
        try{
            //1. Cust goes to his/her cart place
            HttpSession session = request.getSession(false);
            if (session != null) {
                //2. Cust takes his here cart
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    //3.Cust gets items
                    Map<Integer, Integer> itemsList = cart.getItems();
                    if (itemsList != null) {
                        //4. Cust chooses removed book
                        int removedProductID = 0;
                        removedProductID = Integer.parseInt(request.getParameter("txtProductId"));
                        if (removedProductID != 0) {
                            //5. Remove from cart
                            cart.removeFromCart(removedProductID);
                            session.setAttribute("CART", cart);
                        }//items are chosen
                    } //end if 
                }//end if cart existed
            }//session is existed
            
            url = CART_DETAILS;
        }catch (SQLException ex) {
            log("removeFromCartServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("removeFromCartServlet_NamingException: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
