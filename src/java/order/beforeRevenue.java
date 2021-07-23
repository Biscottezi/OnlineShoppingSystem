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
    private String date;
    private int categoryID;

    public beforeRevenue() {
    }

    public beforeRevenue(float salePrice, float listPrice, String date, int categoryID) {
        this.salePrice = salePrice;
        this.listPrice = listPrice;
        this.date = date;
        this.categoryID = categoryID;
    }

    /**
     * @return the salePrice
     */
    public float getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return the listPrice
     */
    public float getListPrice() {
        return listPrice;
    }

    /**
     * @param listPrice the listPrice to set
     */
    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the categoryID
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    
    
}
