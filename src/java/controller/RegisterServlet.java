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
    private final String REGISTER_PAGE = "registerPage.jsp";
    private final String SUCCESS_PAGE = "registerSuccess.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         boolean changed = (request.getParameter("changed") != null);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int role = 4;
        Date dateCreated = null;
        int status = 1;
        String avatar = null;    
        String url = REGISTER_PAGE;
        CustomerError errObj = new CustomerError();
        boolean founderror = false;
        try {
            if (changed) {
                //1.Check user errorr
                if (email.trim().length() < 5 || email.trim().length() > 10) {
                    founderror = true;
                    errObj.setEmailError("Username is required input from 5 to 10 chars");

                    String wrongUsername = request.getParameter("username");
                    request.setAttribute("wrongUsername", wrongUsername);
                }
                if (password.trim().length() < 5 || password.trim().length() > 20) {
                    founderror = true;
                    errObj.setPassErr("Password is required input from 5 to 20 chars");

                } else if (!password.trim().equals(confirmPassword.trim())) {
                    founderror = true;
                    errObj.setConfirmpassErr("Confirm password must match with password!");

                }
                if (fullname.trim().length() < 5 || fullname.trim().length() > 50) {
                    founderror = true;
                    errObj.setFullnameErr("Full name is required input from 5 to 50 chars");                   

                } 
                if (phone.trim().length() < 10 ) {
                    founderror = true;
                    errObj.setFullnameErr("Phone number is required input  10 chars");                   

                }else if (address.trim().length() < 5 || address.trim().length() > 100) {
                    founderror = true;
                    errObj.setAddressErr("Address is required input from 5 to 100 chars");
                }
            }
            if (founderror) {
                //2.1 caching errors, then forward to report error
                request.setAttribute("errObj", errObj);

                String wrongUsername = request.getParameter("email");
                request.setAttribute("wrongUsername", wrongUsername);
                String wrongPassword = request.getParameter("password");
                request.setAttribute("wrongPassword", wrongPassword);
                String wrongConfirmPassword = request.getParameter("confirmPassword");
                request.setAttribute("wrongConfirmPassword", wrongConfirmPassword);
                String wrongFullname = request.getParameter("fullname");
                request.setAttribute("wrongFullname", wrongFullname);
                String wrongAddress = request.getParameter("address");
                request.setAttribute("wrongAddress", wrongAddress);
                String wrongPhone = request.getParameter("phone");
                request.setAttribute("wrongPhone", wrongPhone);

            } else {
                UserDAO dao = new UserDAO();
                boolean result = dao.createNewCustomer(email, password, url, gender, phone, address, status, dateCreated, role, avatar);
                if (result) {
                    url = SUCCESS_PAGE;
                }
            }
        } catch (SQLException ex) {
            String errMsg = ex.getMessage();
            log("RegisterServlet SQLException: " + errMsg);
            if (errMsg.contains("duplicate")) {
                errObj.setEmailError(email + " is existed! Please choose another one!");
                request.setAttribute("errObj", errObj);
            }
        } catch (ClassNotFoundException ex) {
            log("RegisterServlet ClassNotFoundException: " + ex.getMessage());
        }  catch (NamingException ex) {
            log("RegisterServlet NamingException: " + ex.getMessage());
        }finally {
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
