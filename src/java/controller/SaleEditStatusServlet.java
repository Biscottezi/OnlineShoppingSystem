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
import order.OrderDAO;
import orderDetail.OrderDetailDAO;
import orderDetail.OrderItemObj;
import product.ProductDAO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SaleEditStatusServlet", urlPatterns = {"/SaleEditStatusServlet"})
public class SaleEditStatusServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String DETAIL_LIST_PAGE = "SaleMemberOrders.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String selectedOrderID = request.getParameter("selectedOrderID");
        String changedStatus = request.getParameter("status");
        String url = DETAIL_LIST_PAGE;
        try {
            OrderDetailDAO dao = new OrderDetailDAO();
            ArrayList<OrderItemObj> detailList = dao.GetOrderDetailByOrderID(Integer.parseInt(selectedOrderID));
            OrderDAO oDAO= new OrderDAO();
            
            ProductDAO productDAO = new ProductDAO();
            
            productDAO.getAllProduct();
            oDAO.updateStatus(Integer.parseInt(selectedOrderID), Integer.parseInt(changedStatus));
            ProductCategoryDAO cate = new ProductCategoryDAO();
            List<ProductCategoryDTO> categoryList = cate.getCategoryList();
            
            request.setAttribute("detailList", detailList);
            request.setAttribute("categoryList", categoryList);

        } catch (SQLException ex) {
            log("ViewOlderOrderDetailServlet SQLException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("ViewOlderOrderDetailServlet ClassNotFoundException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewOlderOrderDetailServlet NamingException: " + ex.getMessage());
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
