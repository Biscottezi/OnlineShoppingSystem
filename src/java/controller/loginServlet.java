/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    //private final String INVALID_PAGE = "Error.html";
    private final String HOME_PAGE = "viewHomePageServlet";
    private final String MARKETING_DASHBOARD = "MarketingDashboard.jsp";
    private final String SALE_MANAGER_DASHBOARD = "viewSManagerDashboard";
    private final String SALE_MEMBER_DASHBOARD = "SaleMemberDashboard.jsp";
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
        String url = HOME_PAGE;
        
        try{
                String email = request.getParameter("txtEmail");
                String password = request.getParameter("txtPassword");
                UserDAO dao = new UserDAO();
                boolean result = dao.checkLogin(email, password);
                
                if(result){
                    UserDTO user = dao.getUser();
                    if(user.getStatus() == 0){
                        request.setAttribute("LOGIN_ERROR", "This account is disable");
                    }else{
                        HttpSession session = request.getSession(true);

                        session.setAttribute("USER", user);
                        int id = user.getId();
                        session.setAttribute("custId", id);
                        int role = user.getRole();
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
                    }
                }
                else{
                    request.setAttribute("LOGIN_ERROR", "Wrong email or password");
                }
            
        }catch(SQLException ex){
            log("LoginServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("LoginServlet _ Naming:" + ex.getMessage());
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//                response.sendRedirect(url);
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
