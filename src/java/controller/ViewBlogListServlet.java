/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import post.PostDAO;
import post.PostDTO;
import postCategory.PostCategoryDAO;
import postCategory.PostCategoryDTO;


/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewBlogDetail", urlPatterns = {"/ViewBlogDetail"})
public class ViewBlogListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String ERROR_PAGE="error";
    private final String BLOG_DETAIL="BlogDetail";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_PAGE;
                
        try {
            PostDAO dao = new PostDAO();
            dao.getPostDetail();
            List<PostDTO> dto = dao.getPostList();
            if(dto != null){
                request.setAttribute("ALL_POST_LIST", dto);
            }
            PostCategoryDAO postCategoryDao = new PostCategoryDAO();
            postCategoryDao.getAllCategory();
            List<PostCategoryDTO> postCategoryDto = postCategoryDao.getPostCateList();
            if(postCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", postCategoryDto);
            }
            url = BLOG_DETAIL;
        }catch(SQLException ex){
            log("ViewBlogListServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("ViewBlogListServlet _ Naming:" + ex.getMessage());
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
