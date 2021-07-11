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
                String sql = "SELECT TOP 8 ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
    
    public void searchProductByID(int productID)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.makeConnection();
                if(con != null){
                    String sql = "Select ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
                String sql = "SELECT ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
                        + "FROM Product "
                        + "WHERE Status = 1 "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
    
    public void getProductByCategoryCustomer(int categoryID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
    
    public void searchProductNameByCustomer(String productName)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.makeConnection();
                if(con != null){
                    String sql = "Select ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
    
    public ProductDTO GetProductbyID(int productID)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.makeConnection();
                if(con != null){
                    String sql = "Select ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
                    return dto;
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
            return  null;
    }
    
    public void getProducts() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar "
                        + "FROM Product "
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
                    int RatedStar = rs.getInt("RatedStar");
                    ProductDTO dto = new ProductDTO(ProductID, Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar);
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
    
    public int addNewProduct(String title, int categoryID, String thumbnail, String briefInfo, String description, int quantity, float listPrice, float salePrice, int featured, int status)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int newlyAddedProductID = 0;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO Product "
                        + "(Title, ProductCategoryID, Thumbnail, BriefInfo, Description, Quantity, ListPrice, SalePrice, Featured, Status, DateCreated, RatedStar) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), 0)";
                
                stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stm.setString(1, title);
                stm.setInt(2, categoryID);
                stm.setString(3, thumbnail);
                stm.setString(4, briefInfo);
                stm.setString(5, description);
                stm.setInt(6, quantity);
                stm.setFloat(7, listPrice);
                stm.setFloat(8, salePrice);
                stm.setInt(9, featured);
                stm.setInt(10, status);
                
                stm.executeUpdate();
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    newlyAddedProductID = rs.getInt(1);
                }
                return newlyAddedProductID;
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
        return 0;
    }
    
    public boolean updateProduct(int productID, String title, int categoryID, String thumbnail, String briefInfo, String description, int quantity, float listPrice, float salePrice, int featured, int status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2. create SQL string 

                String sql = "UPDATE Product "
                        + "SET Title = ?, ProductCategoryID = ?, Thumbnail = ?, BriefInfo = ?, Description = ?, Quantity = ?, ListPrice = ?, SalePrice = ?, Featured = ?, Status = ? "
                        + "WHERE ProductID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, title);
                stm.setInt(2, categoryID);
                stm.setString(3, thumbnail);
                stm.setString(4, briefInfo);
                stm.setString(5, description);
                stm.setInt(6, quantity);
                stm.setFloat(7, listPrice);
                stm.setFloat(8, salePrice);
                stm.setInt(9, featured);
                stm.setInt(10, status);
                stm.setInt(11, productID);
                
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
    
    public List<averageRatedStar> getAverageRatedStar() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<averageRatedStar> ratedStarList = new ArrayList<>();
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "SELECT Select AVG(RatedStar) as AvgRatedStar, ProductCategoryID "
                        + "from Product "
                        + "Group by ProductCategoryID ";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    float ratedStar = rs.getFloat("AvgRatedStar");
                    int categoryID = rs.getInt("ProductCategoryID");
                    averageRatedStar avgRatedStar = new averageRatedStar(ratedStar, categoryID);
                    
                    ratedStarList.add(avgRatedStar);
                }
                return ratedStarList;
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
        return ratedStarList;
    }
}
