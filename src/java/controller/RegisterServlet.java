/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import error.CustomerError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOMEPAGE = "viewHomePageServlet";
    private final String ERROR_PAGE = "error.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String confirmPassword = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullName");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtMobile");
        int gender = Integer.parseInt(request.getParameter("txtGender"));
        int role = 4;
        int status = 1;
        String avatar = "defaultAvatar.jpg";    
        String url = HOMEPAGE;
        CustomerError errObj = new CustomerError();
        boolean founderror = false;
        
        try{
            if(password.trim().length() < 5 || password.trim().length() > 20){
                founderror = true;
                errObj.setPassErr("Password must be from 5 to 20 characters in length");
            }
            else if(!password.trim().equals(confirmPassword.trim())){
                founderror = true;
                errObj.setConfirmpassErr("Confirm password and password does not match");
            }
            if(phone.trim().length() < 10 || phone.trim().length() > 12){
                founderror = true;
                errObj.setPhoneError("Phone number must be from 10 to 12 digits");
            }
            if(founderror){
                request.setAttribute("REGISTER_ERROR", errObj);
                request.setAttribute("EMAIL_ERROR", email);
                request.setAttribute("PASSWORD_ERROR", password);
                request.setAttribute("CONFIRM_ERROR", confirmPassword);
                request.setAttribute("NAME_ERROR", fullname);
                request.setAttribute("PHONE_ERROR", phone);
                request.setAttribute("ADDRESS_ERROR", address);
            }
            else{
                UserDAO dao = new UserDAO();
                boolean result = dao.createNewCustomer(email, password, fullname, gender, phone, address, status, role, avatar);
                if(!result){
                    url = ERROR_PAGE;
                }
            }
        }
        catch(SQLException ex){
            String msg = ex.getMessage();
            log("RegisterServlet_SQL: " + msg);
            if(msg.contains("duplicate")){
                errObj.setEmailError(email + " already exists");
                request.setAttribute("REGISTER_ERROR", errObj);
            }
        }
        catch(NamingException ex){
            log("RegisterServlet_Naming: " + ex.getMessage());
        }
        finally{
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
