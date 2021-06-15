/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slider;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class SliderDAO implements Serializable{
    
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
            if(con != null){
                    rs.close();
                }
                if(con != null){
                    stm.close();
                }
                if(con != null){
                    con.close();
                }
        }
        return null;
    }
}
