/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class UserDAO implements Serializable {

    private UserDTO user;

    public UserDTO getUser() {
        return user;
    }
    
    private List<UserDTO> userList;

    public List<UserDTO> getUserList() {
        return userList;
    }

    public boolean checkLogin(String email, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select UserID, Name, Gender, Address, Phone, Status, DateCreated, Avatar, Role "
                        + "From [User] "
                        + "Where Email = ? And Password = ?";
                //3.Create statement and assign value for parameters if any
                stm = con.prepareStatement(sql);
                stm.setString(1, email.trim());
                stm.setString(2, password.trim());
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                if (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    int gender = rs.getInt("Gender");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    Date dateCreated = rs.getDate("DateCreated");
                    String avatar = rs.getString("Avatar");
                    int role = rs.getInt("Role");
                    this.user = new UserDTO(id, name, gender, address, email, phone, status, dateCreated, avatar, role, password);
                    return true;
                }//end if rs is existed
            }//end if con is opened
        } finally {

            if(rs != null){
                rs.close();
            }
            if(stm != null){

                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean createNewCustomer(String email, String pass, String fullname, int gender, String phone, String address)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "INSERT INTO [User] "
                        + " (Email, Password, Name, "
                        + " Address, Gender, Phone) "
                        + " VALUES (?,?,?,?,?,?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, pass);
                stm.setString(3, fullname);
                stm.setString(4, address);
                stm.setInt(5, gender);
                stm.setString(6, phone);
                
                int rowAffect = stm.executeUpdate();

                if (rowAffect == 1) {
                    return true;
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

        return false;
    }
    
    public void getAllUser() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password "
                        + "FROM [User] ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");
                    int Gender = rs.getInt("Gender");
                    String Address = rs.getString("Address");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    String Avatar = rs.getString("Avatar");
                    int Role = rs.getInt("Role");
                    String Password = rs.getString("Password");

                    UserDTO dto = new UserDTO(UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password);
                    if(this.userList == null){
                        this.userList = new ArrayList<>();
                    }
                    this.userList.add(dto);
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
    
    public void getUserByID(int ID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password "
                        + "FROM [User] "
                        + "Where UserID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");
                    int Gender = rs.getInt("Gender");
                    String Address = rs.getString("Address");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    String Avatar = rs.getString("Avatar");
                    int Role = rs.getInt("Role");
                    String Password = rs.getString("Password");

                    this.user = new UserDTO(UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password);
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
    
    public void getAllCustomer() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password "
                        + "FROM [User] "
                        + "WHERE Role = 4 AND Status = 1";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");
                    int Gender = rs.getInt("Gender");
                    String Address = rs.getString("Address");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    String Avatar = rs.getString("Avatar");
                    int Role = rs.getInt("Role");
                    String Password = rs.getString("Password");

                    UserDTO dto = new UserDTO(UserID, Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password);
                    if(this.userList == null){
                        this.userList = new ArrayList<>();
                    }
                    this.userList.add(dto);
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
    
    public void updateUser(String email, String pass, String fullname, int gender, String phone, String address)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "INSERT INTO [User] "
                        + " (Email, Password, Name, "
                        + " Address, Gender, Phone) "
                        + " VALUES (?,?,?,?,?,?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, pass);
                stm.setString(3, fullname);
                stm.setString(4, address);
                stm.setInt(5, gender);
                stm.setString(6, phone);
                
                int rowAffect = stm.executeUpdate();
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
