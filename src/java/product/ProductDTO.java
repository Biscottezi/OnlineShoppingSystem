/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class ProductDTO implements Serializable{
    private int id;
    private String title;
    private int categoryId;
    private String thumbnail;
    private String briefInfo;
    private String description;
    private int quantity;
    private float listPrice;
    private float salePrice;
    private int featured;
    private int status;
    private Date createdDate;

    public ProductDTO() {
    }

    public ProductDTO(int id, String title, int categoryId, String thumbnail, String briefInfo, String description, int quantity, float listPrice, float salePrice, int featured, int status, Date createdDate) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.thumbnail = thumbnail;
        this.briefInfo = briefInfo;
        this.description = description;
        this.quantity = quantity;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.featured = featured;
        this.status = status;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
