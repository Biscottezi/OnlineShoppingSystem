/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productImage;

import java.io.Serializable;
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
public class ProductImageDAO implements Serializable{
    private List<Integer> productImageIDList;

    public List<Integer> getProductImageIDList() {
        return productImageIDList;
    }
    
    public void getProductImagesID(int productID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT ImageID "
                        + "FROM ProductImage "
                        + "WHERE ProductID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, productID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int imageID = rs.getInt("ImageID");
                    if (this.productImageIDList == null) {
                        this.productImageIDList = new ArrayList<>();
                    }
                    this.productImageIDList.add(imageID);
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
}
