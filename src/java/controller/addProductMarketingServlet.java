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
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.ProductDAO;
import productAttachedImage.ProductAttachedImageDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "addProductMarketingServlet", urlPatterns = {"/addProductMarketingServlet"})

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class addProductMarketingServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String PRODUCT_MARKETING_PAGE = "viewProductMarketingServlet";
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
        String title = mreq.getParameter("productTitle");
        String categoryID = mreq.getParameter("productCategory");
        String thumbnail = mreq.getFilesystemName("productThumbnail");
        String briefInfo = mreq.getParameter("productBriefInfo");
        String description = mreq.getParameter("productDescription");
        String quantity = mreq.getParameter("productQuantity");
        String listPrice = mreq.getParameter("productBasePrice");
        String salePrice = mreq.getParameter("productSalePrice");
        String chkFeatured = mreq.getParameter("productFeatured");
        String chkStatus = mreq.getParameter("productStatus");
        String[] fileNamelist = mreq.getParameterValues("fileNameList");
        String url = ERROR_PAGE;
        int status = 0;
        int featured = 0;
        
        try{
            if(chkStatus != null){
                status = 1;
            }
            if(chkFeatured != null){
                featured = 1;
            }
            ProductAttachedImageDAO imageDao = new ProductAttachedImageDAO();
            ProductDAO productDao = new ProductDAO();
            int productID = productDao.addNewProduct(title, Integer.parseInt(categoryID), thumbnail, briefInfo, description, Integer.parseInt(quantity), 
                    Float.parseFloat(listPrice), Float.parseFloat(salePrice), featured, status);
            for(int i = 0; i < fileNamelist.length; i++){
                imageDao.addProductImage(fileNamelist[i], productID);
            }
            
            url = PRODUCT_MARKETING_PAGE;
            
        }catch (SQLException ex) {
            log("addProductMarketingServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("addProductMarketingServlet_NamingException: " + ex.getMessage());
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
