/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class beforeRevenue implements Serializable{
    private float salePrice;
    private float listPrice;
    private Date date;
    private int categoryID;

    public beforeRevenue() {
    }

    public beforeRevenue(float salePrice, float listPrice, Date date, int categoryID) {
        this.salePrice = salePrice;
        this.listPrice = listPrice;
        this.date = date;
        this.categoryID = categoryID;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    
}
