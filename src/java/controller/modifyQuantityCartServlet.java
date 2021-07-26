/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.Cart;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "modifyQuantityCartServlet", urlPatterns = {"/modifyQuantityCartServlet"})
public class modifyQuantityCartServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String CART_DETAILS_PAGE = "CartDetails.jsp";
    private final String CART_DETAILS_UPDATE = "CartDetailsUpdate.jsp";
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
        
        try{
            HttpSession session = request.getSession(true);
            //2. Cust takes a cart
            Cart cart = (Cart) session.getAttribute("CART");
            int ID = Integer.parseInt(request.getParameter("txtProductId"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            cart.modifyQuantity(ID, quantity);

            session.setAttribute("CART", cart);
            
            if(session.getAttribute("ORDER") != null){
                url = CART_DETAILS_UPDATE;
            }
            else{
                url = CART_DETAILS_PAGE;
            }
            
        }catch(SQLException ex){
            log("modifyQuantityCartServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("modifyQuantityCartServlet _ Naming:" + ex.getMessage());
        }finally{
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
