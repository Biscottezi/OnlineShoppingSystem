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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import orderDetail.CustomizedOrderDetailDTO;
import orderDetail.OrderDetailDAO;
import orderDetail.OrderDetailDTO;
import user.UserDTO;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class OrderDAO implements Serializable {

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
                        + "FROM [Order] "
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
                    int SaleMemberID = rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID);
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
                        + "FROM [Order] "
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
                    int SaleMemberID = rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID);
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

    public int CreateOrder(int custId, String ReceiverName, int ReceiverGender, String ReceiverAddress, String ReceiverEmail, String ReceiverPhone, String Note, int SaleID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = DBHelper.makeConnection();

        String sql = "INSERT INTO [Order] (OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID,Status)"
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
                //System.out.println("We have just added " + newlyAddedOrderID + " to database");
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
                        + "FROM [Order] "
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
                    int SaleMemberID = rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID);
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
                        + "FROM [Order] "
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
                    int SaleMemberID = rs.getInt("SaleMemberID");

                    OrderDTO oDTO = new OrderDTO(OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID);
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
                        + "FROM [Order] "
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

                String sql = "UPDATE [Order] "
                        + "SET Status = 3 "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, OrderID);

                int rowAffect = stm.executeUpdate();
                if (rowAffect == 1) {
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

                String sql = "UPDATE [Order] "
                        + "SET Status = ? "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setInt(2, OrderID);

                int rowAffect = stm.executeUpdate();
                if (rowAffect == 1) {
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
                        + "From [Order] "
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
                    int SaleMemberID = rs.getInt("SaleMemberID");
                    OrderDTO dto = new OrderDTO(OrderID, Status, OrderedDate, CustomerID, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID);
                    if (this.orderList == null) {
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
                con.close();
            }
        }
    }

    private List<UserDTO> potentialCus;

    public List<UserDTO> getPotentialCusList() {
        return potentialCus;
    }

    public void getPotentialCustomers() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT OrderedDate, ReceiverName, ReceiverAddress, ReceiverEmail, ReceiverGender, ReceiverPhone "
                        + "FROM [Order] "
                        + "WHERE CustomerID is null";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    Date createdDate = rs.getDate("OrderedDate");
                    String Name = rs.getString("ReceiverName");
                    int Gender = rs.getInt("ReceiverGender");
                    String Address = rs.getString("ReceiverAddress");
                    String Email = rs.getString("ReceiverEmail");
                    String Phone = rs.getString("ReceiverPhone");

                    UserDTO dto = new UserDTO(Name, Address, Email, Gender, Phone, createdDate);
                    if (this.potentialCus == null) {
                        this.potentialCus = new ArrayList<>();
                    }
                    this.potentialCus.add(dto);
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
    }

    public int getTotalOrderByStatus(int status) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        int total = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE Status = ? "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                rs = stm.executeQuery();

                while (rs.next()) {
                    total += rs.getInt("TotalOrder");
                }
                return total;
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
        return total;
    }

    public int getTotalPotentialCustomerByDate() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        int totalPotCus = 0;
        String now = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String monthago = java.time.LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(ReceiverName) AS TotalCustomer, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE CustomerID is null AND OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareCall(sql);
                stm.setString(1, monthago);
                stm.setString(2, now);
                rs = stm.executeQuery();

                while (rs.next()) {
                    totalPotCus += rs.getInt("TotalCustomer");
                }
                return totalPotCus;
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
        return totalPotCus;
    }

    public int getTotalCustomerByDate() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        int totalCus = 0;
        String now = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String monthago = java.time.LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        try {
            con = DBHelper.makeConnection();
            while (con != null) {
                String sql = "SELECT COUNT(ReceiverName) AS TotalCustomer, convert(varchar, OrderedDate, 101) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE CustomerID is not null AND OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar, OrderedDate, 101) ";
                stm = con.prepareCall(sql);
                stm.setString(1, monthago);
                stm.setString(2, now);
                rs = stm.executeQuery();

                while (rs.next()) {
                    totalCus += rs.getInt("TotalCustomer");
                }
                return totalCus;
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
        return totalCus;
    }

    public List<beforeRevenue> getBeforeRevenue() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<beforeRevenue> beforeRevenueList = new ArrayList<>();
        String now = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String monthago = java.time.LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT sum(od.Quantity*p.SalePrice) AS SalePrice, sum(od.Quantity*p.ListPrice) AS ListPrice, convert(varchar, OrderedDate, 101) AS OrderDate, p.ProductCategoryID "
                        + "FROM ([Order] o JOIN OrderDetail od ON o.OrderID = od.OrderID) JOIN Product p ON od.ProductID = p.ProductID "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar, OrderedDate, 101), p.ProductCategoryID ";
                stm = con.prepareCall(sql);
                stm.setString(1, monthago);
                stm.setString(2, now);

                rs = stm.executeQuery();

                while (rs.next()) {
                    float salePrice = rs.getFloat("SalePrice");
                    float listPrice = rs.getFloat("ListPrice");
                    String date = rs.getString("OrderDate");
                    int categoryID = rs.getInt("ProductCategoryID");

                    beforeRevenue beforeRevenue = new beforeRevenue(salePrice, listPrice, date, categoryID);
                    beforeRevenueList.add(beforeRevenue);
                }
                return beforeRevenueList;
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
        return beforeRevenueList;
    }

    public boolean updateOrder(int OrderID, String ReceiverName, int ReceiverGender, String ReceiverAddress, String ReceiverEmail, String ReceiverPhone)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [Order] "
                        + "SET OrderedDate =GETDATE(), ReceiverName = ? , ReceiverGender= ?, ReceiverAddress= ?, ReceiverEmail= ?, ReceiverPhone= ? "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, ReceiverName);
                stm.setInt(2, ReceiverGender);
                stm.setString(3, ReceiverAddress);
                stm.setString(4, ReceiverEmail);
                stm.setString(5, ReceiverPhone);
                stm.setInt(6, OrderID);

                int rowAffect = stm.executeUpdate();
                if (rowAffect == 1) {
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

    public List<CustomizedOrderDTO> getOrderListByCustomer(int customerId) throws SQLException, NamingException {
        List<CustomizedOrderDTO> orders = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrderID, [Status], SaleMemberID, CustomerID, OrderedDate, ReceiverName, ReceiverAddress, ReceiverGender, ReceiverEmail, ReceiverPhone, Note "
                        + "From [Order] "
                        + "Where CustomerID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, customerId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    int saleId = rs.getInt("SaleMemberID");
                    int custId = rs.getInt("CustomerID");
                    Date orderedDate = rs.getDate("OrderedDate");
                    String name = rs.getString("ReceiverName");
                    String address = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    String phone = rs.getString("ReceiverPhone");
                    int gender = rs.getInt("ReceiverGender");
                    String note = rs.getString("Note");

                    CustomizedOrderDTO dto = new CustomizedOrderDTO(orderId, status, custId, saleId, orderedDate, name, address, email, phone, note, gender);
                    if (orders == null) {
                        orders = new ArrayList<>();
                    }
                    orders.add(dto);
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
        return orders;
    }

    public CustomizedOrderDTO getOrderByOrderId(int id) throws SQLException, NamingException {
        CustomizedOrderDTO order = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrderID, [Status], SaleMemberID, CustomerID, OrderedDate, ReceiverName, ReceiverAddress, ReceiverGender, ReceiverEmail, ReceiverPhone, Note "
                        + "From [Order] "
                        + "Where OrderID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    int saleId = rs.getInt("SaleMemberID");
                    int custId = rs.getInt("CustomerID");
                    Date orderedDate = rs.getDate("OrderedDate");
                    String name = rs.getString("ReceiverName");
                    String address = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    String phone = rs.getString("ReceiverPhone");
                    int gender = rs.getInt("ReceiverGender");
                    String note = rs.getString("Note");

                    order = new CustomizedOrderDTO(orderId, status, custId, saleId, orderedDate, name, address, email, phone, note, gender);
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
        return order;
    }

    public List<totalInOrderTable> getAdminGraphShipped(String startdate, String enddate, int status) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE Status = ? AND OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setString(2, startdate);
                stm.setString(3, enddate);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public List<totalInOrderTable> getAdminGraphTotal(String startdate, String enddate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public List<totalInOrderTable> getSaleGraphTotalbySaleMember(String startdate, String enddate, int saleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? AND SaleMemberID =? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                stm.setInt(3, saleId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public List<totalInOrderTable> getSaleGraphTotal(String startdate, String enddate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public List<totalInOrderTable> getSaleGraphShipped(String startdate, String enddate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? AND Status = 2 "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public List<totalInOrderTable> getSaleGraphShippedbySaleMember(String startdate, String enddate, int SaleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(OrderID) AS TOTALORDER, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? AND Status = 2 AND SaleMemberID = ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                stm.setInt(3, SaleId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalOrder");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }

    public int CreateOrderGuest(String ReceiverName, int ReceiverGender, String ReceiverAddress, String ReceiverEmail, String ReceiverPhone, String Note, int SaleID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = DBHelper.makeConnection();

        String sql = "INSERT INTO [Order] (OrderedDate, ReceiverName, ReceiverGender, ReceiverAddress, ReceiverEmail, ReceiverPhone, Note, SaleMemberID,Status)"
                + " VALUES (GETDATE() , ?, ?, ?, ?, ?, ?, ?, 0)";
        PreparedStatement stm = null;
        ResultSet rs = null;
        Integer newlyAddedOrderID = 0;
        try {
            stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setString(1, ReceiverName);
            stm.setInt(2, ReceiverGender);
            stm.setString(3, ReceiverAddress);
            stm.setString(4, ReceiverEmail);
            stm.setString(5, ReceiverPhone);
            stm.setString(6, Note);
            stm.setInt(7, SaleID);

            stm.executeUpdate();
            rs = stm.getGeneratedKeys();

            if (rs.next()) {
                newlyAddedOrderID = rs.getInt(1);
                //System.out.println("We have just added " + newlyAddedOrderID + " to database");
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
        return newlyAddedOrderID;
    }

    public List<Revenue> getTotalRevenuebyDate(String startdate, String enddate) throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<Revenue> revenueList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT sum(CASE WHEN p.SalePrice is not null THEN od.Quantity*p.SalePrice ELSE od.Quantity*p.ListPrice END) AS Revenues, convert(varchar(6), OrderedDate, 106) AS OrderDate "
                        + "FROM ([Order] o JOIN OrderDetail od ON o.OrderID = od.OrderID) JOIN Product p ON od.ProductID = p.ProductID "
                        + "WHERE OrderedDate >= ?  AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) "
                        + "ORDER BY OrderDate ASC ";
                stm = con.prepareCall(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);

                rs = stm.executeQuery();

                while (rs.next()) {
                    float revenues = rs.getFloat("Revenues");
                    String date = rs.getString("OrderDate");

                    Revenue revenue = new Revenue(revenues, date);
                    revenueList.add(revenue);
                }
                return revenueList;
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
        return revenueList;
    }

    public List<Revenue> getTotalRevenuebyDateSaleID(String startdate, String enddate, int SaleId) throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<Revenue> revenueList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT sum(CASE WHEN p.SalePrice is not null THEN od.Quantity*p.SalePrice ELSE od.Quantity*p.ListPrice END) AS Revenues, convert(varchar(6), OrderedDate, 106) AS OrderDate "
                        + "FROM ([Order] o JOIN OrderDetail od ON o.OrderID = od.OrderID) JOIN Product p ON od.ProductID = p.ProductID "
                        + "WHERE OrderedDate >= ?  AND OrderedDate <= ? And SaleMemberID = ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) "
                        + "ORDER BY OrderDate ASC ";
                stm = con.prepareCall(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                stm.setInt(3, SaleId);

                rs = stm.executeQuery();

                while (rs.next()) {
                    float revenues = rs.getFloat("Revenues");
                    String date = rs.getString("OrderDate");

                    Revenue revenue = new Revenue(revenues, date);
                    revenueList.add(revenue);
                }
                return revenueList;
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
        return revenueList;
    }

    public List<CustomizedOrderDTO> getAllOrderList() throws SQLException, NamingException {
        List<CustomizedOrderDTO> orders = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrderID, o.[Status], SaleMemberID, CustomerID, "
                        + "u.Name, OrderedDate, ReceiverName, ReceiverAddress, ReceiverGender, "
                        + "ReceiverEmail, ReceiverPhone, Note "
                        + "From [Order] o, [User] u "
                        + "Where u.UserID=o.CustomerID "
                        + "ORDER BY OrderedDate DESC";

                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    int saleId = rs.getInt("SaleMemberID");
                    int custId = rs.getInt("CustomerID");
                    Date orderedDate = rs.getDate("OrderedDate");
                    String name = rs.getString("ReceiverName");
                    String address = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    String phone = rs.getString("ReceiverPhone");
                    int gender = rs.getInt("ReceiverGender");
                    String note = rs.getString("Note");
                    String customerName = rs.getString("Name");

                    CustomizedOrderDTO dto = new CustomizedOrderDTO(orderId, status, custId, saleId, orderedDate, name, address, email, phone, note, gender, customerName);
                    if (orders == null) {
                        orders = new ArrayList<>();
                    }
                    orders.add(dto);
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
        return orders;
    }

    public List<CustomizedOrderDTO> getAllOrderListbySaleID(int saleMemId) throws SQLException, NamingException {
        List<CustomizedOrderDTO> orders = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrderID, o.[Status], SaleMemberID, CustomerID, "
                        + "u.Name, OrderedDate, ReceiverName, ReceiverAddress, ReceiverGender, "
                        + "ReceiverEmail, ReceiverPhone, Note "
                        + "From [Order] o, [User] u "
                        + "Where u.UserID=o.CustomerID AND SaleMemberID=? "
                        + "ORDER BY OrderedDate DESC";

                stm = con.prepareStatement(sql);
                stm.setInt(1, saleMemId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    int saleId = rs.getInt("SaleMemberID");
                    int custId = rs.getInt("CustomerID");
                    Date orderedDate = rs.getDate("OrderedDate");
                    String name = rs.getString("ReceiverName");
                    String address = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    String phone = rs.getString("ReceiverPhone");
                    int gender = rs.getInt("ReceiverGender");
                    String note = rs.getString("Note");
                    String customerName = rs.getString("Name");

                    CustomizedOrderDTO dto = new CustomizedOrderDTO(orderId, status, custId, saleId, orderedDate, name, address, email, phone, note, gender, customerName);
                    if (orders == null) {
                        orders = new ArrayList<>();
                    }
                    orders.add(dto);
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
        return orders;
    }

    public CustomizedOrderDTO getSaleOrderByOrderId(int id) throws SQLException, NamingException {
        CustomizedOrderDTO order = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrderID, o.[Status], SaleMemberID, CustomerID, "
                        + "u.Name, OrderedDate, ReceiverName, ReceiverAddress, ReceiverGender, "
                        + "ReceiverEmail, ReceiverPhone, Note "
                        + "From [Order] o, [User] u "
                        + "Where u.UserID=o.CustomerID AND OrderID = ?  "
                        + "ORDER BY OrderedDate DESC";

                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();

                if (rs.next()) {
                    int orderId = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    int saleId = rs.getInt("SaleMemberID");
                    int custId = rs.getInt("CustomerID");
                    Date orderedDate = rs.getDate("OrderedDate");
                    String name = rs.getString("ReceiverName");
                    String address = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    String phone = rs.getString("ReceiverPhone");
                    int gender = rs.getInt("ReceiverGender");
                    String note = rs.getString("Note");
                    String customerName = rs.getString("Name");

                    order = new CustomizedOrderDTO(orderId, status, custId, saleId, orderedDate, name, address, email, phone, note, gender, customerName);
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
        return order;
    }

    public boolean updateOrderSale(int OrderID, int status, int salememberid)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [Order] "
                        + "SET Status = ?, SaleMemberID = ? "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setInt(2, salememberid);
                stm.setInt(3, OrderID);

                int rowAffect = stm.executeUpdate();
                if (rowAffect == 1) {
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

    public String GetEmailByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        String email = "";
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT ReceiverEmail "
                        + "FROM [Order] "
                        + "WHERE OrderID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();

                if (rs.next()) {
                    email = rs.getString("ReceiverEmail");

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
        return email;
    }

    public OrderDTO getOrderDTOByOrderID(int orderID) throws SQLException, NamingException {
        OrderDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT OrderID, [Status], OrderedDate, CustomerID, ReceiverName, ReceiverAddress, ReceiverEmail, ReceiverGender, ReceiverPhone, Note, SaleMemberID "
                        + "FROM [Order] "
                        + "WHERE OrderID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int ordID = rs.getInt("OrderID");
                    int status = rs.getInt("Status");
                    Date ordDate = rs.getDate("OrderedDate");
                    int custID = rs.getInt("CustomerID");
                    String name = rs.getString("ReceiverName");
                    String addr = rs.getString("ReceiverAddress");
                    String email = rs.getString("ReceiverEmail");
                    int gender = rs.getInt("ReceiverGender");
                    String phone = rs.getString("ReceiverPhone");
                    String note = rs.getString("Note");
                    int saleID = rs.getInt("SaleMemberID");

                    dto = new OrderDTO(ordID, status, ordDate, custID, name, gender, addr, email, phone, note, saleID);
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
        return dto;
    }

    public boolean updateOrderCheckout(int OrderID, String ReceiverName, int ReceiverGender, String ReceiverAddress, String ReceiverEmail, String ReceiverPhone, String note)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [Order] "
                        + "SET OrderedDate = GETDATE(), ReceiverName = ? , ReceiverGender= ?, ReceiverAddress= ?, ReceiverEmail= ?, ReceiverPhone= ?, Note = ? "
                        + "WHERE OrderID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, ReceiverName);
                stm.setInt(2, ReceiverGender);
                stm.setString(3, ReceiverAddress);
                stm.setString(4, ReceiverEmail);
                stm.setString(5, ReceiverPhone);
                stm.setString(6, note);
                stm.setInt(7, OrderID);

                int rowAffect = stm.executeUpdate();
                if (rowAffect > 0) {
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

    public List<totalInOrderTable> getMktGraphTotal(String startdate, String enddate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<totalInOrderTable> totalList = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(DISTINCT CustomerID) as TotalCust, convert(varchar(6), OrderedDate, 106) as OrderDate "
                        + "FROM [Order] "
                        + "WHERE OrderedDate >= ? AND OrderedDate <= ? "
                        + "GROUP BY convert(varchar(6), OrderedDate, 106) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, startdate);
                stm.setString(2, enddate);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int TotalOrder = rs.getInt("TotalCust");
                    String date = rs.getString("OrderDate");

                    totalInOrderTable total = new totalInOrderTable(TotalOrder, date);
                    totalList.add(total);
                }
                return totalList;
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
        return totalList;
    }
    public int GetSaleByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        int id = 0;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT SaleMemberID "
                        + "FROM [Order] "
                        + "WHERE OrderID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();

                if (rs.next()) {
                    id= rs.getInt(1);

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
        return id;
    }
}
