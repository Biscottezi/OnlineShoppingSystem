/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class averageRatedStar implements Serializable{
    private float averageStar;
    private int categoryID;

    public averageRatedStar() {
    }

    public averageRatedStar(float averageStar, int categoryID) {
        this.averageStar = averageStar;
        this.categoryID = categoryID;
    }

    public float getAverageStar() {
        return averageStar;
    }

    public void setAverageStar(float averageStar) {
        this.averageStar = averageStar;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    } 
}
