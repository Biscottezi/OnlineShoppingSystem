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
import order.OrderDAO;
import order.Revenue;
import order.totalInOrderTable;
import user.SaleMember;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "changeSaleGraphServlet", urlPatterns = {"/changeSaleGraphServlet"})
public class changeSaleGraphServlet extends HttpServlet {

    private final String SALE_PAGE = "SaleManagerDashboard.jsp";
    private final String SALEMEMBER_PAGE = "SaleMemberDashboard.jsp";
    private final String ERROR_PAGE = "viewSManagerDashboardServlet";
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
        String daterange = request.getParameter("daterange");
        HttpSession session = request.getSession(false);
        int saleid=0;
        List<SaleMember> listsale = (List<SaleMember>)session.getAttribute("SALELIST");
        SaleMember chosen = new SaleMember();
        if (request.getParameter("slSaleName")!=null && !request.getParameter("slSaleName").isEmpty()) {
            saleid = Integer.parseInt(request.getParameter("slSaleName"));
            for (int i = 0; i<listsale.size();i++){
                if (listsale.get(i).getId()==saleid){
                    chosen.setId(listsale.get(i).getId());
                    chosen.setName(listsale.get(i).getName());
                    break;
                }
            }
        }
        int status=0;
        if (request.getParameter("graphstatus")!=null && !request.getParameter("graphstatus").isEmpty()) {
            status = Integer.parseInt(request.getParameter("graphstatus"));
        }
        String[] date = daterange.split(" - ");
        String start = date[0];
        String end = date[1];
        try {
            OrderDAO orderdao = new OrderDAO();
            if (status>0){
                if (saleid<=0){
                    List<totalInOrderTable> graph = orderdao.getSaleGraphShipped(start, end);
                    session.setAttribute("ORDERGRAPH", graph);
                } 
                else {
                    List<totalInOrderTable> graph = orderdao.getSaleGraphShippedbySaleMember(start, end, chosen.getId());
                    session.setAttribute("ORDERGRAPH", graph);
                }
            }
            else {
                if (saleid<=0){
                    List<totalInOrderTable> graph = orderdao.getSaleGraphTotal(start, end);
                    session.setAttribute("ORDERGRAPH", graph);
                } 
                else {
                    List<totalInOrderTable> graph = orderdao.getSaleGraphTotalbySaleMember(start, end, chosen.getId());
                    session.setAttribute("ORDERGRAPH", graph);
                }
            }
            //end ordergraph
            if (saleid<=0){
                List<Revenue> revenueList = orderdao.getTotalRevenuebyDate(start,end);
                session.setAttribute("REVGRAPH", revenueList);
            } 
            else {
                List<Revenue> revenueList = orderdao.getTotalRevenuebyDate(start,end);
                session.setAttribute("REVGRAPH", revenueList);
            }
            //end revenuegraph
            session.setAttribute("DATESTART", start);
            session.setAttribute("DATEEND", end);
            request.setAttribute("SaleMember", chosen);
            request.setAttribute("graphstatus", status);
            UserDTO user = (UserDTO)session.getAttribute("USER");
            if (user.getRole()==2) 
                url=SALE_PAGE;
            else 
                url = SALEMEMBER_PAGE;
        } 
        catch(SQLException ex){
            log("changeAdminGraphServlet_SQL:" + ex.getMessage());
        }
        catch(NamingException ex){
            log("changeAdminGraphServlet_Naming:" + ex.getMessage());
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
