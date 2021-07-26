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
import slider.SliderDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updateSliderMarketingServlet", urlPatterns = {"/updateSliderMarketingServlet"})
public class updateSliderMarketingServlet extends HttpServlet {
    private final String ERROR_PAGE="Error.html";
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
        String sliderID = request.getParameter("sliderID");
        String title = request.getParameter("sliderTitle");
        String description = request.getParameter("sliderDescription");
        int status;
        if(request.getParameter("sliderStatus") == null){
            status = 0;
        }
        else{
            status = 1;
        }
        String SLIDER_DETAILS_PAGE = "viewSliderDetailsMarketingServlet?sliderID=" + sliderID;
        String url = ERROR_PAGE;
        
        try {
            SliderDAO sliderDao = new SliderDAO();
            boolean result = sliderDao.updateSlider(Integer.parseInt(sliderID), title, description, status);
            if(result){
                url = SLIDER_DETAILS_PAGE;
            }
            
        }catch(SQLException ex){
            log("updateSliderMarketingServlet _ SQL:" + ex.getMessage());
        }catch(NamingException ex){
            log("updateSliderMarketingServlet _ Naming:" + ex.getMessage());
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
