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
    private Date date;
    private int categoryID;

    public Revenue() {
    }

    public Revenue(float revenue, Date date, int categoryID) {
        this.revenue = revenue;
        this.date = date;
        this.categoryID = categoryID;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
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
