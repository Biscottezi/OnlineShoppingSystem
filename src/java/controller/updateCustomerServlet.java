/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import customerOldDetails.CustomerOldDetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updateCustomerServlet", urlPatterns = {"/updateCustomerServlet"})
public class updateCustomerServlet extends HttpServlet {
    private final String CUSTOMER_DETAILS_PAGE = "viewCustomerDetailsServlet";
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
        String id = request.getParameter("cusID");
        String name = request.getParameter("cusName");
        String gender = request.getParameter("cusGender");
        String address = request.getParameter("cusAddress");
        String phone = request.getParameter("cusMobile");
        String url = ERROR_PAGE;
        
        try{
            UserDAO userDao = new UserDAO();
            boolean result = userDao.updateCustomer(Integer.parseInt(id), name, Integer.parseInt(gender), address, phone);
            CustomerOldDetailsDAO oldDao = new CustomerOldDetailsDAO();
            oldDao.AddCustomerOldDetails(name, Integer.parseInt(gender), address, phone, Integer.parseInt(id));
            if(result){
                url = CUSTOMER_DETAILS_PAGE;
            }
        }catch(SQLException ex){
            log("updateCustomerServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("updateCustomerServlet _ Naming:" + ex.getMessage());
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
