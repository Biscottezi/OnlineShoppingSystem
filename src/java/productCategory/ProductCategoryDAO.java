/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productCategory;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class ProductCategoryDAO implements Serializable{
    
    private List<ProductCategoryDTO> categoryList;

    public List<ProductCategoryDTO> getCategoryList() {
        return categoryList;
    }
    
    public void getAllCategory()throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductCategoryID, Name "
                        + "FROM ProductCategory "
                        + "ORDER BY Name ASC";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int categoryID = rs.getInt("ProductCategoryID");
                    String categoryName = rs.getString("Name");
                    ProductCategoryDTO dto = new ProductCategoryDTO(categoryID, categoryName);
                    if(this.categoryList == null){
                        this.categoryList = new ArrayList<>();
                    }
                    this.categoryList.add(dto);
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
                con.close();
            }
        }
    }
}
