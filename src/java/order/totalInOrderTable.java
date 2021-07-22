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
public class totalInOrderTable implements Serializable{
    private int total;
    private String date;

    public totalInOrderTable() {
    }

    public totalInOrderTable(int total, String date) {
        this.total = total;
        this.date = date;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
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

    
}
