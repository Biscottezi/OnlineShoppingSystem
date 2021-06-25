/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

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
public class ProductDAO implements Serializable{
    private List<ProductDTO> productList;

    public List<ProductDTO> getProductList() {
        return productList;
    }
    
    private ProductDTO product;
    
    public ProductDTO getProduct(){
        return product;
    }
    
    public void getFeaturedProduct() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT TOP 8 ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated "
                        + "FROM Product "
                        + "WHERE Featured = 1 AND Status = 1 "
                        + "ORDER by DateCreated desc";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int ProductID = rs.getInt("ProductID");
                    String Title = rs.getString("Title");
                    int ProductCategoryID = rs.getInt("ProductCategoryID");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    float ListPrice = rs.getFloat("ListPrice");
                    float SalePrice = rs.getFloat("SalePrice");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated);
                    if(this.productList == null){
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
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
    
    public void searchProductID(int productID)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.makeConnection();
                if(con != null){
                    String sql = "Select ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated "
                            + "From Product "
                            + "Where ProductID = ?";
                    
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, productID);
                    rs = stm.executeQuery();
                    
                    if(rs.next()){
                        int ProductID = rs.getInt("ProductID");
                    String Title = rs.getString("Title");
                    int ProductCategoryID = rs.getInt("ProductCategoryID");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    float ListPrice = rs.getFloat("ListPrice");
                    float SalePrice = rs.getFloat("SalePrice");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated);
                    this.product = dto;
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
    
    public void getAllProduct() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated "
                        + "FROM Product "
                        + "WHERE Featured = 1 AND Status = 1 "
                        + "ORDER by DateCreated desc";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int ProductID = rs.getInt("ProductID");
                    String Title = rs.getString("Title");
                    int ProductCategoryID = rs.getInt("ProductCategoryID");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    float ListPrice = rs.getFloat("ListPrice");
                    float SalePrice = rs.getFloat("SalePrice");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated);
                    if(this.productList == null){
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
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
    
    public void getProductByCategory(int categoryID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated "
                        + "FROM Product "
                        + "WHERE ProductCategoryID = ? "
                        + "ORDER by DateCreated desc";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int ProductID = rs.getInt("ProductID");
                    String Title = rs.getString("Title");
                    int ProductCategoryID = rs.getInt("ProductCategoryID");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    float ListPrice = rs.getFloat("ListPrice");
                    float SalePrice = rs.getFloat("SalePrice");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated);
                    if(this.productList == null){
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
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
    
    public void searchProductName(String productName)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.makeConnection();
                if(con != null){
                    String sql = "Select ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated "
                            + "From Product "
                            + "Where Title LIKE ?";
                    
                    stm = con.prepareStatement(sql);
                    stm.setString(1,"%" + productName + "%");
                    rs = stm.executeQuery();
                    
                    if(rs.next()){
                        int ProductID = rs.getInt("ProductID");
                    String Title = rs.getString("Title");
                    int ProductCategoryID = rs.getInt("ProductCategoryID");
                    String Thumbnail = rs.getString("Thumbnail");
                    String BriefInfo = rs.getString("BriefInfo");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    float ListPrice = rs.getFloat("ListPrice");
                    float SalePrice = rs.getFloat("SalePrice");
                    int Featured = rs.getInt("Featured");
                    int Status = rs.getInt("Status");
                    Date DateCreated = rs.getDate("DateCreated");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated);
                    if(this.productList == null){
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
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
