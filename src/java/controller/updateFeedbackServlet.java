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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "updateFeedbackServlet", urlPatterns = {"/updateFeedbackServlet"})
public class updateFeedbackServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.html";
    private final String FEEDBACK_DETAILS_PAGE = "viewFeedbackDetailsMarketingServlet";
    
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
        String fbID = request.getParameter("feedbackID");
        String fbStatus = request.getParameter("feedbackStatus");
        try{
            int feedbackID = Integer.parseInt(fbID);
            FeedBackDAO dao = new FeedBackDAO();
            boolean result = false;
            if(fbStatus != null){
                result = dao.updateFeedback(feedbackID, 1);
            }
            else{
                result = dao.updateFeedback(feedbackID, 0);
            }
            if(result){
                url = FEEDBACK_DETAILS_PAGE;
            }
        }
        catch(NumberFormatException ex){
            log("UpdateFeedbackServlet_NumberFormat: " + ex.getMessage());
        }
        catch(SQLException ex){
            log("UpdateFeedbackServlet_SQL: " + ex.getMessage());
        }
        catch(NamingException ex){
            log("UpdateFeedbackServlet_Naming: " + ex.getMessage());
        }
        finally{
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
