/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

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
public class PostDAO implements Serializable {

    private List<PostDTO> postList;

    public List<PostDTO> getPostList() {
        return postList;
    }
    private PostDTO post;

    public void getFeaturedPost() throws SQLException, NamingException {
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT TOP 5 PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "WHERE Featured = 1 AND Status = 1 "
                        + "ORDER by DateCreated desc";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
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
                    if (this.postList == null) {
                        this.postList = new ArrayList<>();
                    }
                    this.postList.add(dto);
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

    public void getPostbyID(int PostID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "WHERE PostID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, PostID);
                rs = stm.executeQuery();

                while (rs.next()) {

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
                    
                    this.post = dto;
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


    public void getPostCustomer() throws SQLException, NamingException {
        Connection con = null;

         
        CallableStatement stm = null;

        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "WHERE Featured = 1 AND Status = 1 "
                        + "ORDER by DateCreated desc";

                stm = con.prepareCall(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
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
                    if (this.postList == null) {
                        this.postList = new ArrayList<>();
                    }
                    this.postList.add(dto);
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

    public PostDTO getPost() {
        return post;
    }

    public void searchPostName(String postName)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "From Post "
                        + "Where Title LIKE ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + postName + "%");
                rs = stm.executeQuery();

               while (rs.next()) {
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
    
    public void getAllPost() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "ORDER by DateCreated desc";
                stm = con.prepareStatement(sql);
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
    public void getPostbyCategory(int PostCategoryID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated "
                        + "FROM Post "
                        + "WHERE PostCategoryID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, PostCategoryID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int PostID = rs.getInt("PostID");
                    String Title = rs.getString("Title");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Author = rs.getString("Author");
                    String Description = rs.getString("Description");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    
                    Date DateCreated = rs.getDate("DateCreated");
                    PostDTO dto = new PostDTO(PostID, Title, Thumbnail, BriefInfo, Author, Description, Featured, Status, PostCategoryID, DateCreated);
                    if (this.postList == null) {
                        this.postList = new ArrayList<>();
                    }
                    this.postList.add(dto);
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
