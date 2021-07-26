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
import com.oreilly.servlet.MultipartRequest;
import feedBackAttachedImage.FeedBackAttachedImageDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

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
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            MultipartRequest mreq = new MultipartRequest(request, basePath, 500000 * 1024);
            String productID = mreq.getParameter("txtProductId");
            String name = mreq.getParameter("txtName");
            String email = mreq.getParameter("txtEmail");
            String phone = mreq.getParameter("txtMobile");
            String rating = mreq.getParameter("txtRating");
            int ratedStar = Integer.parseInt(rating);
            String content = mreq.getParameter("txtFeedbackContent");
            String[] fileNamelist = mreq.getParameterValues("fileNameList");
            
            
            
            if(productID != null){
                int prodID = Integer.parseInt(productID);
                FeedBackDAO dao = new FeedBackDAO();
                FeedBackAttachedImageDAO imgDao = new FeedBackAttachedImageDAO();
                
                int generatedID = dao.addNewProductFeedback(name, content, email, phone, ratedStar, prodID);
                for(int i = 0; i < fileNamelist.length; i++){
                    imgDao.addNewImage(fileNamelist[i], generatedID);
                }
                if(generatedID > 0){
                    url = HOMEPAGE;
                }
            }
            else{
                FeedBackDAO dao = new FeedBackDAO();
                FeedBackAttachedImageDAO imgDao = new FeedBackAttachedImageDAO();
                int generatedID = dao.addNewGeneralFeedback(name, content, email, phone, ratedStar);
                for(int i = 0; i < fileNamelist.length; i++){
                    imgDao.addNewImage(fileNamelist[i], generatedID);
                }
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
