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
import javax.servlet.http.HttpSession;
import product.ProductDAO;
import product.ProductDTO;
import productAttachedImage.ProductAttachedImageDAO;
import productAttachedImage.ProductAttachedImageDTO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "viewProductDetailsServlet", urlPatterns = {"/viewProductDetailsServlet"})
public class viewProductDetailsServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String PRODUCT_DETAILS_PAGE = "ProductDetails.jsp";
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
        String productID = request.getParameter("productID");
        String url = ERROR_PAGE;
        try{
            HttpSession session = request.getSession(false);
            ProductDAO productDao = new ProductDAO();
            productDao.searchProductByID(Integer.parseInt(productID));
            session.setAttribute("PRODUCT_ID", productID);
            ProductDTO productDto = productDao.getProduct();
            if(productDto != null){
                request.setAttribute("PRODUCT_DETAILS", productDto);
            }
            
            ProductCategoryDAO productCategoryDao = new ProductCategoryDAO();
            productCategoryDao.getAllCategory();
            List<ProductCategoryDTO> productCategoryDto = productCategoryDao.getCategoryList();
            if(productCategoryDto != null){
                request.setAttribute("PRODUCT_CATEGORY", productCategoryDto);
            }
            
            ProductAttachedImageDAO imageDao = new ProductAttachedImageDAO();
            imageDao.getProductImages(Integer.parseInt(productID));
            List<ProductAttachedImageDTO> imageDto = imageDao.getProductImageList();
            if(imageDto != null){
                request.setAttribute("PRODUCT_IMAGES", imageDto);
            }
            url = PRODUCT_DETAILS_PAGE;
        }catch(SQLException ex){
            log("viewProductDetailsServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("viewProductDetailsServlet _ Naming:" + ex.getMessage());
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
