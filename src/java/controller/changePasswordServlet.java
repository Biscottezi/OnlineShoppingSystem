/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import error.changePasswordError;
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

/**
 *
 * @author ASUS
 */
@WebServlet(name = "changePasswordServlet", urlPatterns = {"/changePasswordServlet"})
public class changePasswordServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String HOME_PAGE = "viewHomePageServlet";
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
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        String oldPassword = request.getParameter("txtOldPassword");
        String newPassword = request.getParameter("txtNewPassword");
        String confirmPassword = request.getParameter("txtConfirmPassword");
        String url = ERROR_PAGE;
        changePasswordError error = new changePasswordError();
        boolean founderror = false;
        
        try{
            UserDAO dao = new UserDAO();
            
            if(!oldPassword.trim().equals(password.trim())){
                founderror = true;
                error.setOldPassErr("Old Password is incorrect");
            }
            if (newPassword.trim().length() < 5 || newPassword.trim().length() > 20) {
                founderror = true;
                error.setNewPassErr("Password is required input from 5 to 20 chars");

            } else if (!newPassword.trim().equals(confirmPassword.trim())) {
                founderror = true;
                error.setConfirmPassErr("Confirm password must match with password!");
            }
            
            if(founderror){
                request.setAttribute("CHANGE_PASS_ERR", error);
            }else{
                dao.resetNewPassword(Integer.parseInt(userID), newPassword);
                request.getSession(false).invalidate();
            }
            
            url = HOME_PAGE;
        }catch (SQLException ex) {
            log("changePasswordServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("changePasswordServlet_NamingException: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
