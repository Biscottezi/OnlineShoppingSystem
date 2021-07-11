/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import utils.uploadFile;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updatePostMarketingServlet", urlPatterns = {"/updatePostMarketingServlet"})
public class updatePostMarketingServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String POST_MARKETING_PAGE = "MarketingPostList.jsp";
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
        String postID = request.getParameter("postID");
        String title = request.getParameter("txtTitle");
        String thumbnail = uploadFile.uploadFile(request, "thumnail");
        String briefInfo = request.getParameter("txtBriefInfo");
        String author = request.getParameter("txtAuthor");
        String description = request.getParameter("txtDescription");
        String chkFeatured = request.getParameter("chkFeatured");
        String chkStatus = request.getParameter("chkStatus");
        String categoryID = request.getParameter("categoryID");
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
