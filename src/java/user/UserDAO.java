/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author ASUS
 */
public class UserDAO implements Serializable{
    public boolean createNewCustomer(String email,String pass, String fullname,int gender,String phone, String address) 
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
