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
    private List<ProductAttachedImageDTO> productImageList;

    public List<ProductAttachedImageDTO> getProductImageList() {
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
                        + "WHERE productID = ? ";

                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("PostID");
                    String name = rs.getString("Title");
                    ProductAttachedImageDTO dto = new ProductAttachedImageDTO(id, name);
                    if (this.productImageList == null) {
                        this.productImageList = new ArrayList<>();
                    }
                    this.productImageList.add(dto);
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
