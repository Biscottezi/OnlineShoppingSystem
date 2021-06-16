/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import product.ProductDAO;
import product.ProductDTO;
import slider.SliderDAO;
import slider.SliderDTO;
import sliderContent.SliderContentDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "viewHomePageServlet", urlPatterns = {"/viewHomePageServlet"})
public class viewHomePageServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String HOME_PAGE = "homepage.jsp";
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
        String url = ERROR_PAGE;
        
        try {
            ProductDAO productDao = new ProductDAO();
            productDao.getFeaturedProduct();
            List<ProductDTO> productList = productDao.getProductList();
            if(productList != null){
                request.setAttribute("FEATURED_PRODUCT", productList);
            }
            
            PostDAO postDao = new PostDAO();
            postDao.getFeaturedPost();
            List<PostDTO> postList = postDao.getPostList();
            if(postList != null){
                request.setAttribute("FEATURED_POST", postList);
            }
            
            SliderDAO sliderDao = new SliderDAO();
            SliderDTO slider = sliderDao.getSlider();
            if(slider != null){
                request.setAttribute("SLIDER", slider);
                SliderContentDAO sliderContentDao = new SliderContentDAO();
                sliderContentDao.getProductID(slider.getId());
                List<Integer> productIDList = sliderContentDao.getProductIDList();
                if(productIDList != null){
                    List<ProductDTO> sliderProducts = new ArrayList<>();
                    for(int i = 0; i < productIDList.size(); i++){
                        productDao.searchProductID(productIDList.get(i));
                        sliderProducts.add(productDao.getProduct());
                    }
                    request.setAttribute("SLIDER_PRODUCTS", sliderProducts);
                }
            }
            
            
            url = HOME_PAGE;
        }catch(SQLException ex){
            log("showProductServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("showProductServlet _ Naming:" + ex.getMessage());
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
