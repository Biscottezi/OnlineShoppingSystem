/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedBackAttachedImage;

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
public class FeedBackAttachedImageDAO implements Serializable{
    private List<FeedBackAttachedImageDTO> listImages;
    
    public List<FeedBackAttachedImageDTO> getFeedbackImages(){
        return listImages;
    }
    
    public void getImageByFeedback(int id) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ImageID, Name, FeedbackID "
                        + "FROM FeedbackAttachedImage "
                        + "WHERE FeedbackID = ? ";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int imageId = rs.getInt("ImageID");
                    String imageName = rs.getString("Name");
                    int feedbackId = rs.getInt("FeedbackID");
                    
                    FeedBackAttachedImageDTO feedbackImage = new FeedBackAttachedImageDTO(imageId, imageName, feedbackId);
                    
                    if(this.listImages == null){
                        this.listImages = new ArrayList<>();
                    }
                    
                    listImages.add(feedbackImage);
                }
            }
        }
        finally{
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
    
    public boolean addNewImage(String name, int fbId) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO FeedbackAttachedImage (Name, FeedbackID) "
                        + "VALUES (?, ?) ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, fbId);
                
                int rowAffected = stm.executeUpdate();
                if(rowAffected != 0){
                    return true;
                }
            }
        }
        finally{
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
