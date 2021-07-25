/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedBack;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class FeedBackDAO implements Serializable{
    private List<FeedBackDTO> feedbackList;

    public List<FeedBackDTO> getFeedbackList() {
        return feedbackList;
    }
    
    private FeedBackDTO feedback;
    
    public FeedBackDTO getFeedback(){
        return feedback;
    }
    
    public void getAllFeedBack() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  FeedBackID, Name, FeedbackContent, Email, Phone, Feedback.[Status], Feedback.RatedStar, Feedback.ProductID, Title "
                        + "FROM FeedBack left join Product on Feedback.ProductID = Product.ProductID "
                        + "ORDER by [Status] asc";

                stm = con.prepareCall(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int FeedBackID = rs.getInt("FeedBackID");
                    String Name = rs.getString("Name");
                    String FeedbackContent = rs.getString("FeedbackContent");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    int RatedStar = rs.getInt("RatedStar");
                    int ProductID = rs.getInt("ProductID");
                    String ProductTitle  = rs.getString("Title");
                    FeedBackDTO dto = new FeedBackDTO(FeedBackID, Name, FeedbackContent, Email, Phone, Status, RatedStar, ProductID, ProductTitle);
                    if (this.feedbackList == null) {
                        this.feedbackList = new ArrayList<>();
                    }
                    this.feedbackList.add(dto);
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
    
    public void getFeedBackById(int feedbackID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  FeedBackID, Name, FeedbackContent, Email, Phone, Feedback.[Status], Feedback.RatedStar, Feedback.ProductID, Title "
                        + "FROM FeedBack left join Product on Feedback.ProductID = Product.ProductID "
                        + "WHERE FeedbackID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, feedbackID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int FeedBackID = rs.getInt("FeedBackID");
                    String Name = rs.getString("Name");
                    String FeedbackContent = rs.getString("FeedbackContent");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    int RatedStar = rs.getInt("RatedStar");
                    int ProductID = rs.getInt("ProductID");
                    String ProductTitle  = rs.getString("Title");
                    FeedBackDTO dto = new FeedBackDTO(FeedBackID, Name, FeedbackContent, Email, Phone, Status, RatedStar, ProductID, ProductTitle);
                    this.feedback = dto;
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
    
    public boolean addNewGeneralFeedback(String name, String content, String email, String phone, int ratedStar) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO Feedback (Name, FeedbackContent, Email, Phone, [Status], RatedStar) "
                        + "VALUES (?, ?, ?, ?, 0, ?) ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, content);
                stm.setString(3, email);
                stm.setString(4, phone);
                stm.setInt(5, ratedStar);
                
                int rowAffected = stm.executeUpdate();
                if(rowAffected > 0){
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
    
    public boolean addNewProductFeedback(String name, String content, String email, String phone, int ratedStar, int productID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO Feedback (Name, FeedbackContent, Email, Phone, [Status], RatedStar, ProductID) "
                        + "VALUES (?, ?, ?, ?, 0, ?, ?) ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, content);
                stm.setString(3, email);
                stm.setString(4, phone);
                stm.setInt(5, ratedStar);
                stm.setInt(6, productID);
                
                int rowAffected = stm.executeUpdate();
                if(rowAffected > 0){
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
    
    public boolean updateFeedback(int id, int status) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "UPDATE Feedback "
                        + "SET [Status] = ? "
                        + "WHERE FeedbackID = ? ";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setInt(2, id);
                int rowAffected = stm.executeUpdate();
                
                if(rowAffected > 0){
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
    
    public int getNoOfFeedbackByMonth() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int totalFeedback = 0;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT COUNT(FeedbackID) as NumOfFeed "
                        + "FROM Feedback ";
                
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    totalFeedback += rs.getInt("NumOfFeed");
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
        return totalFeedback;
    }
}
