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
import user.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "changePasswordServlet", urlPatterns = {"/changePasswordServlet"})
public class changePasswordServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String HOME_PAGE = "viewHomePageServlet";
    private final String MARKETING_DASHBOARD = "viewMarketingDashboardServlet";
    private final String SALE_MANAGER_DASHBOARD = "viewSManagerDashboardServlet";
    private final String SALE_MEMBER_DASHBOARD = "ViewSMemberDashboardServlet";
    private final String ADMIN_DASHBOARD = "viewAdminDashboardServlet";
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
                dao.getUserByID(Integer.parseInt(userID));
                UserDTO dto = dao.getUser();
                int role = dto.getRole();
                switch (role){
                            case 0:
                                url = MARKETING_DASHBOARD;
                                break;
                            case 1:
                                url = SALE_MEMBER_DASHBOARD;
                                break;
                            case 2:
                                url = SALE_MANAGER_DASHBOARD;
                                break;
                            case 3:
                                url = ADMIN_DASHBOARD;
                                break;
                            case 4:
                                url = HOME_PAGE;
                                break;
                        }
                
            }else{
                dao.resetNewPassword(Integer.parseInt(userID), newPassword);
                request.getSession(false).invalidate();
            }
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
