/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliderContent;

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
public class SliderContentDAO implements Serializable{
    
    private List<Integer> productIDList;

    public List<Integer> getProductIDList() {
        return productIDList;
    }
    
    public void getProductID(int sliderID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductID "
                        + "FROM SliderContent "
                        + "WHERE SliderID = ?";
                
                stm = con.prepareCall(sql);
                stm.setInt(1, sliderID);
                rs = stm.executeQuery();
                if(this.productIDList != null){
                    this.productIDList.clear();
                }
                while(rs.next()){
                    int ID = rs.getInt("ProductID");
                    if(this.productIDList == null){
                        this.productIDList = new ArrayList<>();
                    }
                    this.productIDList.add(ID);
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
    
    public boolean addProductToSlider(int sliderID, int productID)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO SliderContent(SliderID, ProductID) "
                        + "VALUES (?, ?)";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, sliderID);
                stm.setInt(2, productID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
                    return true;
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
        return false;
    }
}
