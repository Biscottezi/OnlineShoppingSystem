/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class OrderDAO implements Serializable{
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
}
