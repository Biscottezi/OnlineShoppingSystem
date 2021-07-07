/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import product.ProductDAO;
import product.ProductDTO;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class OrderDetailDAO implements Serializable{
     public ArrayList<OrderItemObj> GetOrderDetailByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, ProductID, Quantity "
                        + "FROM tblOrderDetail "
                        + "WHERE OrderID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();
                ArrayList<OrderItemObj> result = new ArrayList<>();
                while (rs.next()) {
                    
                    ProductDAO productDAO = new ProductDAO();
                    ProductDTO productDTO = productDAO.GetProductbyID(rs.getInt("ProductID"));
                    OrderItemObj OrderItemObj = new OrderItemObj(productDTO, rs.getInt("Quantity"));
                    result.add(OrderItemObj);
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
     public boolean CreateOrderDetail(int OrderID, int ProductID, int quantity) throws
            SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO OrderDetail(OrderID, ProductID, quantity) "
                        + "VALUES (?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, OrderID);
                stm.setInt(2, ProductID);
                stm.setInt(3, quantity);
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
     public int GetQuantityByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Integer quantity = 0;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                String orderSQLString = "SELECT OrderID, ProductID, Quantity "
                        + "FROM tblOrderDetail "
                        + "WHERE OrderID = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();
                
                if (rs.next()) {
                     quantity = rs.getInt("Quantity");
                    
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
        return quantity;
    }    
}
