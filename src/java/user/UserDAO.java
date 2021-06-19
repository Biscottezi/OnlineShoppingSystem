/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            if (con != null) {
                rs.close();
            }
            if (con != null) {

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

                String sql = "INSERT INTO tblUser "
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
}
