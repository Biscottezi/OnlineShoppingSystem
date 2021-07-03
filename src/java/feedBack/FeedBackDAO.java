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
                String sql = "SELECT  FeedBackID, Name, FeedbackContent, Email, Phone, Status, RatedStar, ProductID "
                        + "FROM FeedBack "
                        + "ORDER by DateCreated desc";

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
                    FeedBackDTO dto = new FeedBackDTO(FeedBackID, Name, FeedbackContent, Email, Phone, Status, RatedStar, ProductID);
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
}
