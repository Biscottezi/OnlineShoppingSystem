/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slider;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import post.PostDTO;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class SliderDAO implements Serializable{
    
    private List<PostDTO> postList;

    public List<PostDTO> getPostList() {
        return postList;
    }
    public void getFeaturedPost() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT TOP 5 PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "WHERE Featured = 1 AND Status = 1 "
                        + "ORDER by DateCreated desc";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int PostID = rs.getInt("PostID");
                    String Title = rs.getString("Title");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Author = rs.getString("Author");
                    String Description = rs.getString("Description");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    int PostCategoryID = rs.getInt("PostCategoryID");
                    Date DateCreated = rs.getDate("DateCreated");
                    PostDTO dto = new PostDTO(PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated);
                    if(this.postList == null){
                        this.postList = new ArrayList<>();
                    }
                    this.postList.add(dto);
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
    }
}
