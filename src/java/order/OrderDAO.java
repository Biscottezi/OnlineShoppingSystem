/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;



import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import user.UserDTO;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class OrderDAO implements Serializable{
     private List<OrderDTO> orderList;
     
    public List<OrderDTO> getOrderList() {
        return orderList;
    }
    public ArrayList<OrderDTO> GetOrderListByCustID(String custID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID "
                        + "FROM Order "
                        + "WHERE CustomerID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setString(1, custID);
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("OrderID");
                    int Status = rs.getInt("Status");
                    Date OrderedDate = rs.getDate("OrderedDate");
                    int CustomerID = rs.getInt("CustomerID");
                    String ReceiverName = rs.getString("ReceiverName");
                    int ReceiverGender = rs.getInt("ReceiverGender");
                    String ReceiverAddress = rs.getString("ReceiverAddress");
                    String ReceiverEmail = rs.getString("ReceiverEmail");
                    String ReceiverPhone = rs.getString("ReceiverPhone");
                    String Note = rs.getString("Note");
                    int SaleMemberID= rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate , CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note,SaleMemberID);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
    public ArrayList<OrderDTO> SearchOrderList(String custID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID "
                        + "FROM Order "
                        + "WHERE CustomerID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setString(1, custID);
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("OrderID");
                    int Status = rs.getInt("Status");
                    Date OrderedDate = rs.getDate("OrderedDate");
                    int CustomerID = rs.getInt("CustomerID");
                    String ReceiverName = rs.getString("ReceiverName");
                    int ReceiverGender = rs.getInt("ReceiverGender");
                    String ReceiverAddress = rs.getString("ReceiverAddress");
                    String ReceiverEmail = rs.getString("ReceiverEmail");
                    String ReceiverPhone = rs.getString("ReceiverPhone");
                    String Note = rs.getString("Note");
                    int SaleMemberID= rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate , CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note,SaleMemberID);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
    public int CreateOrder(int custId, String ReceiverName,int ReceiverGender, String ReceiverAddress, String ReceiverEmail, String ReceiverPhone, String Note, int SaleID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = DBHelper.makeConnection();

        String sql = "INSERT INTO tblOrder(OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID,Status)"
                + " VALUES (GETDATE() , ?, ?, ?, ?, ?, ?, ?, ?, 0)";
        PreparedStatement stm = null;
        ResultSet rs = null;
        Integer newlyAddedOrderID = 0;
        try {
            stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1, custId);
            stm.setString(2, ReceiverName);
            stm.setInt(3, ReceiverGender);
            stm.setString(4, ReceiverAddress);
            stm.setString(5, ReceiverEmail);
            stm.setString(6, ReceiverPhone);
            stm.setString(7, Note);
            stm.setInt(8, SaleID);
            

            stm.executeUpdate();
            rs = stm.getGeneratedKeys();

            if (rs.next()) {
                newlyAddedOrderID = rs.getInt(1);
                System.out.println("We have just added " + newlyAddedOrderID + " to database");
            }
        } finally {
            if (rs != null) {
                con.close();
            }
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return newlyAddedOrderID;
    }
    public ArrayList<OrderDTO> GetAllOrder() throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID "
                        + "FROM Order "
                        + "ORDER by DateCreated desc";

                prestm = connection.prepareStatement(orderSQLString);
               
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("OrderID");
                    int Status = rs.getInt("Status");
                    Date OrderedDate = rs.getDate("OrderedDate");
                    int CustomerID = rs.getInt("CustomerID");
                    String ReceiverName = rs.getString("ReceiverName");
                    int ReceiverGender = rs.getInt("ReceiverGender");
                    String ReceiverAddress = rs.getString("ReceiverAddress");
                    String ReceiverEmail = rs.getString("ReceiverEmail");
                    String ReceiverPhone = rs.getString("ReceiverPhone");
                    String Note = rs.getString("Note");
                    int SaleMemberID= rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate , CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note,SaleMemberID);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
    public ArrayList<OrderDTO> GetOrderListBySaleID(String saleID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID "
                        + "FROM Order "
                        + "WHERE SaleMemberID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setString(1, saleID);
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("OrderID");
                    int Status = rs.getInt("Status");
                    Date OrderedDate = rs.getDate("OrderedDate");
                    int CustomerID = rs.getInt("CustomerID");
                    String ReceiverName = rs.getString("ReceiverName");
                    int ReceiverGender = rs.getInt("ReceiverGender");
                    String ReceiverAddress = rs.getString("ReceiverAddress");
                    String ReceiverEmail = rs.getString("ReceiverEmail");
                    String ReceiverPhone = rs.getString("ReceiverPhone");
                    String Note = rs.getString("Note");
                    int SaleMemberID= rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate , CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note,SaleMemberID);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public int GetOrderStatusByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Integer status = 0;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, Status "
                        + "FROM tblOrder "
                        + "WHERE OrderID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();
                
                if (rs.next()) {
                     status = rs.getInt("Status");
                    
                }
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return status;
    }    
    public boolean updateCancelStatus(int OrderID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE tblOrder "
                        + "SET Status = 3 "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);                               
                stm.setInt(1, OrderID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
                    return true;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public boolean updateStatus(int OrderID, int status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE tblOrder "
                        + "SET Status = ? "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);                               
                stm.setInt(1, status);
                stm.setInt(2, OrderID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
                    return true;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public void searchCustName(String custName)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID "
                        + "From tblOrder "
                        + "Where ReceiverName LIKE ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + custName + "%");
                rs = stm.executeQuery();

               while (rs.next()) {
                    int OrderID = rs.getInt("OrderID");
                    int Status = rs.getInt("Status");
                    Date OrderedDate = rs.getDate("OrderedDate");
                    int CustomerID = rs.getInt("CustomerID");
                    String ReceiverName = rs.getString("ReceiverName");
                    int ReceiverGender = rs.getInt("ReceiverGender");
                    String ReceiverAddress = rs.getString("ReceiverAddress");
                    String ReceiverEmail = rs.getString("ReceiverEmail");
                    String ReceiverPhone = rs.getString("ReceiverPhone");
                    String Note = rs.getString("Note");
                    int SaleMemberID= rs.getInt("SaleMemberID");
                    OrderDTO dto = new OrderDTO();
                    if(this.orderList == null){
                        this.orderList = new ArrayList<>();
                    }
                    this.orderList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
            }
        }
    }
    
    private List<UserDTO> potentialCus;
    
    public List<UserDTO> getPotentialCusList(){
        return potentialCus;
    }
    
    public void getPotentialCustomers() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT DISTINCT OrderedDate, ReceiverName, ReceiverAddress, ReceiverEmail, ReceiverGender, ReceiverPhone, "
                        + "FROM [Order] "
                        + "WHERE CustomerID is null";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    Date createdDate = rs.getDate("OrderedDate");
                    String Name = rs.getString("ReceiverName");
                    int Gender = rs.getInt("ReceiverGender");
                    String Address = rs.getString("ReceiverAddress");
                    String Email = rs.getString("ReceiverEmail");
                    String Phone = rs.getString("ReceiverPhone");

                    UserDTO dto = new UserDTO(Name, Address, Email, Gender, Phone, createdDate);
                    if(this.potentialCus == null){
                        this.potentialCus = new ArrayList<>();
                    }
                    this.potentialCus.add(dto);
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){

            }
        }
    }
    
    public List<totalInOrderTable> getTotalOrderByStatus(int status) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE Status = ? "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                rs = stm.executeQuery();
                
                if(rs.next()){
                    int TotalOrder = rs.getInt("TotalOrder");
                    Date date = rs.getDate("OrderDate");
                    
                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){

            }
        }
        return totalList;
    }
    
    public List<totalInOrderTable> getTotalPotentialCustomerByDate() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT COUNT(ReceiverName) AS TotalCustomer, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE CustomerID is null "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                if(rs.next()){
                    int TotalOrder = rs.getInt("TotalCustomer");
                    Date date = rs.getDate("OrderDate");
                    
                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){

            }
        }
        return totalList;
    }
    
    public List<totalInOrderTable> getTotalCustomerByDate() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT COUNT(ReceiverName) AS TotalCustomer, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE CustomerID is not null "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                if(rs.next()){
                    int TotalOrder = rs.getInt("TotalCustomer");
                    Date date = rs.getDate("OrderDate");
                    
                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){

            }
        }
        return totalList;
    }
    
    public List<beforeRevenue> getBeforeRevenue() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<beforeRevenue> beforeRevenueList = new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT sum(od.Quantity*p.SalePrice) AS SalePrice, sum(od.Quantity*p.ListPrice) AS ListPrice, convert(varchar, OrderedDate, 101) AS OrderDate, p.ProductCategoryID "
                        + "FROM ([Order] o JOIN OrderDetail od ON o.OrderID = od.OrderID) JOIN Product p ON od.ProductID = p.ProductID "
                        + "GROUP BY convert(varchar, OrderedDate, 101), p.ProductCategoryID ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                if(rs.next()){
                    float salePrice = rs.getFloat("SalePrice");
                    float listPrice = rs.getFloat("ListPrice");
                    Date date = rs.getDate("OrderDate");
                    int categoryID = rs.getInt("ProductCategoryID");
                    
                    beforeRevenue beforeRevenue = new beforeRevenue(salePrice, listPrice, date, categoryID);
                    beforeRevenueList.add(beforeRevenue);
                }
                return beforeRevenueList;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){

            }
        }
        return beforeRevenueList;
    }
}

