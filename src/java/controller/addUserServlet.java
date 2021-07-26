/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;
import utils.sendMail;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "addUserServlet", urlPatterns = {"/addUserServlet"})

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)


public class addUserServlet extends HttpServlet {
    private final String USER_LiST_PAGE = "viewUserListPageServlet";
    private final String ERROR_PAGE = "Error.html";
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
        String url = ERROR_PAGE;
        String fullName = mreq.getParameter("txtFullName");
        String gender = mreq.getParameter("txtGender");
        String address = mreq.getParameter("txtAddress");
        String email = mreq.getParameter("txtEmail");
        String phone = mreq.getParameter("txtMobile");
        String chkStatus = mreq.getParameter("chkStatus");
        String avatar = mreq.getFilesystemName("avatar");
        String role = mreq.getParameter("txtRole");
        String password;
        int status = 0;
        
        try{
            if(chkStatus != null){
                status = 1;
            }
            
            //Create a random password
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int) 
                (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            password = buffer.toString();
            
            UserDAO dao = new UserDAO();
            dao.AddUserByAdmin(fullName, Integer.parseInt(gender), address, email, phone, status, avatar, Integer.parseInt(role), password);
            
            sendMail.mailCreatedUser(email, password);
            
            url = USER_LiST_PAGE;
        }catch(SQLException ex){
            log("addUserServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("addUserServlet _ Naming:" + ex.getMessage());
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
