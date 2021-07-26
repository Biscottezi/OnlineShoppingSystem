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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;
import user.UserDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updateUserProfileServlet", urlPatterns = {"/updateUserProfileServlet"})
public class updateUserProfileServlet extends HttpServlet {
    private final String ERROR_PAGE = "error";
    private final String HOME_PAGE = "viewHomePage";
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
        String name = request.getParameter("txtName");
        String gender = request.getParameter("txtGender");
        String phone = request.getParameter("txtPhone");
        String address = request.getParameter("txtAddress");
        String userID = request.getParameter("userID");
        String url = ERROR_PAGE;
        
        try {
            UserDAO userDao = new UserDAO();
            boolean result = userDao.updateUserProfile(Integer.parseInt(userID), name, Integer.parseInt(gender), phone, address);
            CustomerOldDetailsDAO oldDao = new CustomerOldDetailsDAO();
            oldDao.AddCustomerOldDetails(name, Integer.parseInt(gender), address, phone, Integer.parseInt(userID));
            userDao.getUserByID(Integer.parseInt(userID));
            UserDTO userDto = userDao.getUser();
            HttpSession session = request.getSession(false);
            session.setAttribute("USER", userDto);
            if(result){
                url = HOME_PAGE;
            }
        } catch (SQLException ex) {
            log("updateUserProfileServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("updateUserProfileServlet_NamingException: " + ex.getMessage());
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
