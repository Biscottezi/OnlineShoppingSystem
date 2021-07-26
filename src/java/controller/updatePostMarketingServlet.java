/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
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
import post.PostDAO;
import post.PostDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updatePostMarketingServlet", urlPatterns = {"/updatePostMarketingServlet"})
public class updatePostMarketingServlet extends HttpServlet {
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
        String postID = mreq.getParameter("postID");
        String title = mreq.getParameter("postTitle");
        String thumbnail = mreq.getFilesystemName("postThumbnail");
        String briefInfo = mreq.getParameter("postBriefInfo");
        String author = mreq.getParameter("postAuthor");
        String description = mreq.getParameter("postDescription");
        String chkFeatured = mreq.getParameter("postFeatured");
        String chkStatus = mreq.getParameter("postStatus");
        String categoryID = mreq.getParameter("postCategory");
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
            if(thumbnail == null){
                dao.getPostbyID(Integer.parseInt(postID));
                PostDTO post = dao.getPost();
                thumbnail = post.getThumbnail();
            }
            boolean result = dao.updatePost(Integer.parseInt(postID), title, thumbnail, briefInfo, author, description, featured, status, Integer.parseInt(categoryID));
            if(result){
                url = POST_MARKETING_PAGE;
            }
            
        }catch(SQLException ex){
            log("updatePostMarketingServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("updatePostMarketingServlet _ Naming:" + ex.getMessage());
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
