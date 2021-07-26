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
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import post.PostDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "addPostMarketingServlet", urlPatterns = {"/addPostMarketingServlet"})
public class addPostMarketingServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String POST_MARKETING_PAGE = "viewPostListMarketingServlet";
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
        String title = mreq.getParameter("txtTitle");
        String thumbnail = mreq.getFilesystemName("postThumbnail");
        String briefInfo = mreq.getParameter("txtBriefInfo");
        String author = mreq.getParameter("txtAuthor");
        String description = mreq.getParameter("txtDescription");
        String chkFeatured = mreq.getParameter("chkFeatured");
        String chkStatus = mreq.getParameter("chkStatus");
        String categoryID = mreq.getParameter("categoryID");
        int featured = 0;
        int status = 0;
        String url = ERROR_PAGE;
        
        try{
            if(chkStatus != null){
                status = 1;
            }
            if(chkFeatured != null){
                featured = 1;
            }
            PostDAO dao = new PostDAO();
            boolean result = dao.addPost(title, thumbnail, briefInfo, author, description, featured, status, Integer.parseInt(categoryID));
            if(result){
                url = POST_MARKETING_PAGE;
            }
            
            
        }catch(SQLException ex){
            log("addPostMarketingServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("addPostMarketingServlet _ Naming:" + ex.getMessage());
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
