/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slider;

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
public class SliderDAO implements Serializable{
    
    private List<SliderDTO> sliderList;
    
    public List<SliderDTO> getSliderList(){
        return sliderList;
    }
    
    
    public SliderDTO getSlider() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT TOP 1 SliderID, Title, Description, Status "
                        + "FROM Slider ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int SliderID = rs.getInt("SliderID");
                    String Title = rs.getString("Title");
                    String Description = rs.getString("Description");
                    int Status = rs.getInt("Status");
                    SliderDTO dto = new SliderDTO(SliderID, Title, Description, Status);
                    return dto;
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
        return null;
    }
    
    public void getAllSlider() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT SliderID, Title, Description, Status "
                        + "FROM Slider ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int SliderID = rs.getInt("SliderID");
                    String Title = rs.getString("Title");
                    String Description = rs.getString("Description");
                    int Status = rs.getInt("Status");
                    
                    if(this.sliderList == null){
                        this.sliderList = new ArrayList<>();
                    }
                    SliderDTO dto = new SliderDTO(SliderID, Title, Description, Status);
                    this.sliderList.add(dto);
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
    
    public SliderDTO getSliderByID(int ID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT SliderID, Title, Description, Status "
                        + "FROM Slider "
                        + "WHERE SliderID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int SliderID = rs.getInt("SliderID");
                    String Title = rs.getString("Title");
                    String Description = rs.getString("Description");
                    int Status = rs.getInt("Status");
                    SliderDTO dto = new SliderDTO(SliderID, Title, Description, Status);
                    return dto;
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
        return null;
    }
    
    public boolean updateSlider(int id, String title, String description, int status) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "UPDATE Slider "
                        + "SET Title = ?, Description = ?, Status = ? "
                        + "WHERE SliderID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, title);
                stm.setString(2, description);
                stm.setInt(3, status);
                stm.setInt(4, id);
                
                int affectedRow = stm.executeUpdate();
                
                if(affectedRow == 1){
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
