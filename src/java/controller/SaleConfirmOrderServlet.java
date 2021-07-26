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
import orderDetail.OrderDetailDTO;
import orderDetail.OrderItemObj;
import product.ProductDAO;
import productCategory.ProductCategoryDAO;
import productCategory.ProductCategoryDTO;
import user.UserDAO;
import utils.sendMail;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SaleConfirmOrderServlet", urlPatterns = {"/SaleConfirmOrderServlet"})
public class SaleConfirmOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String DETAIL_LIST_PAGE = "SaleOrderDetails.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String selectedOrderID = request.getParameter("selectedOrderID");
         String SaleID = request.getParameter("SaleID");
        String url = DETAIL_LIST_PAGE;
        try {
            OrderDetailDAO detaildao = new OrderDetailDAO();
            List<OrderDetailDTO> detailList = detaildao.getDetailsByOrderID(Integer.parseInt(selectedOrderID));
            ProductDAO pDao = new ProductDAO();
             OrderDAO oDAO = new OrderDAO();
             int saleID = oDAO.GetSaleByOrderID(Integer.parseInt(selectedOrderID));
             UserDAO uDAO = new UserDAO();
            for(int i = 0; i < detailList.size(); ++i){
                int prodID = detailList.get(i).getProductId();
                int quantity = detailList.get(i).getQuantity();
                int stock = pDao.getQuantityByProductID(prodID);
                if (quantity >= stock){
                    request.setAttribute("QUANTITY_ERROR", "Product is not enough!");
                    oDAO.updateStatus(Integer.parseInt(selectedOrderID), 2);
                    uDAO.updateSaleStatus(saleID);
                    return;
                }
            }
              
            pDao.getAllProduct();
            String email= oDAO.GetEmailByOrderID(Integer.parseInt(selectedOrderID));
            oDAO.updateStatus(Integer.parseInt(selectedOrderID), 2);
            uDAO.updateSaleStatus(saleID);
            sendMail.mailConfirmOrder(email, Integer.parseInt(selectedOrderID));
            
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
