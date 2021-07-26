/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import user.UserDTO;

/**
 *
 * @author ASUS
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "updateAvatarServlet", urlPatterns = {"/updateAvatarServlet"})
public class updateAvatarServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String HOME_PAGE = "viewHomePageServlet";
    private final String MARKETING_DASHBOARD = "viewMarketingDashboardServlet";
    private final String SALE_MANAGER_DASHBOARD = "viewSManagerDashboardServlet";
    private final String SALE_MEMBER_DASHBOARD = "ViewSMemberDashboardServlet";
    private final String ADMIN_DASHBOARD = "viewAdminDashboardServlet";
    private static final String UPLOAD_DIR = "img";
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
        String applicationPath = request.getServletContext().getRealPath("");
        String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
        MultipartRequest mreq = new MultipartRequest(request, basePath, 500000 * 1024);
        String avatar = mreq.getFilesystemName("avatar");
        
        String url = ERROR_PAGE;
        
        try{
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO)session.getAttribute("USER");
            int userID = user.getId();
            UserDAO dao = new UserDAO();
            boolean result = dao.updateUserAvatar(userID, avatar);
            dao.getUserByID(userID);
            UserDTO newUser = dao.getUser();
            session.setAttribute("USER", newUser);
            if(result){
                switch(newUser.getRole()){
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
        } catch (SQLException ex) {
            log("updateUserProfileServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("updateUserProfileServlet_NamingException: " + ex.getMessage());
        } finally {
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
