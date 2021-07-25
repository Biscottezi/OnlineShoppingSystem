/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postCategory;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import productCategory.ProductCategoryDTO;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class PostCategoryDAO implements Serializable{
    
    private List<PostCategoryDTO> PostCateList;

    public List<PostCategoryDTO> getPostCateList() {
        return PostCateList;
    }
    
    public void getAllCategory()throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT PostCategoryID, Name "
                        + "FROM PostCategory "
                        + "ORDER BY Name ASC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int categoryID = rs.getInt("PostCategoryID");
                    String categoryName = rs.getString("Name");
                    PostCategoryDTO dto = new PostCategoryDTO(categoryID, categoryName);
                    if(this.PostCateList == null){
                        this.PostCateList = new ArrayList<>();
                    }
                    this.PostCateList.add(dto);
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
