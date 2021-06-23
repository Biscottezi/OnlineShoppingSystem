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
}
