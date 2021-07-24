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
public class Revenue implements Serializable{
    private float revenue;
    private String date;
    private int categoryID;

    public Revenue() {
    }

    public Revenue(float revenue, String date, int categoryID) {
        this.revenue = revenue;
        this.date = date;
        this.categoryID = categoryID;
    }

    public Revenue(float revenue, String date) {
        this.revenue = revenue;
        this.date = date;
    }

    /**
     * @return the revenue
     */
    public float getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(float revenue) {
        this.revenue = revenue;
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
