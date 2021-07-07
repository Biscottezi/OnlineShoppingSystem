/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerOldDetails;

import java.io.Serializable;
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
public class CustomerOldDetailsDAO implements Serializable{
    
    private List<CustomerOldDetailsDTO> oldDetailsList;
    
    public List<CustomerOldDetailsDTO> getOldDetailsList(){
        return oldDetailsList;
    }
    
    public void getCustomerOldDetailsByID(int ID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT OldID, Name, Gender, Address, Phone, DateCreated, CustomerID "
                        + "FROM CustomerOldDetails "
                        + "Where CustomerID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int OldID = rs.getInt("OldID");
                    String Name = rs.getString("Name");
                    int Gender = rs.getInt("Gender");
                    String Address = rs.getString("Address");
                    String Phone = rs.getString("Phone");
                    Date DateCreated = rs.getDate("DateCreated");
                    int CustomerID = rs.getInt("CustomerID");
                    if(this.oldDetailsList == null){
                        this.oldDetailsList = new ArrayList<>();
                    }
                    CustomerOldDetailsDTO dto = new CustomerOldDetailsDTO(OldID, Name, Gender, Address, Phone, DateCreated, CustomerID);
                    
                    this.oldDetailsList.add(dto);
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
}
