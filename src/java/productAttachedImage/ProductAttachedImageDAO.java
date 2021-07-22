/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productAttachedImage;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class ProductAttachedImageDAO implements Serializable{
    private List<String> productImageList;

    public List<String> getProductImageList() {
        return productImageList;
    }
    
    public void getProductImages(int productID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT ImageID, Name "
                        + "FROM ProductAttachedImage "
                        + "WHERE ProductID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, productID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("Name");
                    if (this.productImageList == null) {
                        this.productImageList = new ArrayList<>();
                    }
                    this.productImageList.add(name);
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
    
    public boolean addProductImage(String name, int productID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO ProductAttachedImage "
                        + "(Name, ProductID)"
                        + "VALUES (?, ?) ";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, productID);

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
    
    public boolean removeProductImage(int productID, int imageID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM ProductAttachedImage "
                        + "WHERE ImageID = ? AND ProductID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, imageID);
                stm.setInt(2, productID);

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
}
