/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import feedBack.FeedBackDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.uploadFile;

/**
 *
 * @author nguye
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

@WebServlet(name = "submitFeedbackServlet", urlPatterns = {"/submitFeedbackServlet"})
public class submitFeedbackServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String HOMEPAGE = "viewHomePageServlet";

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
        String url = ERROR_PAGE;
        try{
            String productID = request.getParameter("txtProductId");
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtMobile");
            String rating = request.getParameter("txtRating");
            int ratedStar = Integer.parseInt(rating);
            String content = request.getParameter("txtFeedbackContent");
            String avatar = uploadFile.uploadFile(request, "txtFeedbackImages");
            if(productID != null){
                int prodID = Integer.parseInt(productID);
                FeedBackDAO dao = new FeedBackDAO();
                int generatedID = dao.addNewProductFeedback(name, content, email, phone, ratedStar, prodID);
                if(generatedID > 0){
                    url = HOMEPAGE;
                }
            }
            else{
                FeedBackDAO dao = new FeedBackDAO();
                int generatedID = dao.addNewGeneralFeedback(name, content, email, phone, ratedStar);
                if(generatedID > 0){
                    url = HOMEPAGE;
                }
            }
        }
        catch(SQLException ex){
            log("SubmitFeedbackServlet_SQL: " + ex.getMessage());
        }
        catch(NamingException ex){
            log("SubmitFeedbackServlet_Naming: " + ex.getMessage());
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
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
