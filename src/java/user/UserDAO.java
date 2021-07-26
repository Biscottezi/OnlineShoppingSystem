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
    private List<SaleMember> saleList;

    public List<UserDTO> getUserList() {
        return userList;
    }
    
    public List<SaleMember> getSaleMemberList() {
        return saleList;
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

    public boolean createNewCustomer(String email, String password, String name, int gender, String phone, 
            String address,int status, int role, String avatar)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "INSERT INTO [User] "
                        + "(Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password) "
                        + "VALUES(?, ?, ?, ?, ?, ?, GETDATE(), ?, ?, ?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, gender);
                stm.setString(3, address);
                stm.setString(4, email);
                stm.setString(5, phone);
                stm.setInt(6, status);
                stm.setString(7, avatar);
                stm.setInt(8, role);
                stm.setString(9, password);
                
                               
                
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
    
    public boolean updateUser(int userID, int role, int status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Role = ?, Status = ? "
                        + "WHERE UserID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, role);
                stm.setInt(2, status);
                stm.setInt(3, userID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
    
    public boolean AddUserByAdmin(String name, int gender, String address, String email, String phone, int status, String avatar, int role, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "INSERT INTO [User] "
                        + "(Name, Gender, Address, Email, Phone, Status, DateCreated, Avatar, Role, Password) "
                        + "VALUES(?, ?, ?, ?, ?, ?, GETDATE(), ?, ?, ?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, gender);
                stm.setString(3, address);
                stm.setString(4, email);
                stm.setString(5, phone);
                stm.setInt(6, status);
                stm.setString(7, avatar);
                stm.setInt(8, role);
                stm.setString(9, password);
                
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

    public void getSaleMembers() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "Select UserID, Name "
                           + "From [User] " 
                           + "WHERE [Role] = 1 AND Status = 1";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");

                    SaleMember smember = new SaleMember(UserID, Name);
                    if(this.saleList == null){
                        this.saleList = new ArrayList<>();
                    }
                    this.saleList.add(smember);
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
    
    public boolean updateCustomer(int cusID, String name, int gender, String address, String phone)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Name = ?, Gender = ?, Address = ?, Phone = ? "
                        + "WHERE UserID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, gender);
                stm.setString(3, address);
                stm.setString(4, phone);
                stm.setInt(5, cusID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
    
    public int getUserID(String email) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int UserID=0;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT UserID "
                        + "FROM [User] "
                        + "WHERE Email LIKE ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()){
                UserID = rs.getInt("UserID");
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
        return  UserID;
    }
    
    public boolean resetNewPassword(int userID, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Password = ? "
                        + "WHERE UserID = ? ";

                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setInt(2, userID);
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
    
    public boolean updateUserProfile(int userID, String name, int gender, String phone, String address)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Name = ?, Gender = ?, Address = ?, Phone = ? "
                        + "WHERE UserID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, gender);
                stm.setString(3, address);
                stm.setString(4, phone);
                stm.setInt(5, userID);
                        
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
    
    public boolean updateUserAvatar(int userID, String avatar)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Avatar = ? "
                        + "WHERE UserID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, avatar);
                stm.setInt(2, userID);
                        
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
    
    public List<Integer> getSaleMemberActive() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<Integer> saleActive =new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT TOP 1 UserID "
                        + "FROM [User] "
                        + "Where Role = 1 AND Status = 1 ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
               while(rs.next()){
                    int UserID = rs.getInt("UserID");
                    saleActive.add(UserID);
                }
                return saleActive;
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
        return saleActive;
    }
    
    public int getNoOfCustomerByMonth(String now, String monthago) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int totalCustomer = 0;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT COUNT(UserID) as NumOfCust "
                        + "FROM [User] "
                        + "WHERE Role = 4 AND DateCreated >= ? AND DateCreated <= ? ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, monthago);
                stm.setString(2, now);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    totalCustomer += rs.getInt("NumOfCust");
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
        return totalCustomer;
    }
    public boolean updateSaleStatus(int userID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE [User] "
                        + "SET Status = 1 "
                        + "WHERE UserID = ? AND Role = 1";

                stm = con.prepareStatement(sql);
                
                stm.setInt(1, userID);
                        
                
                int rowAffect = stm.executeUpdate();
                if(rowAffect == 1){
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
}
