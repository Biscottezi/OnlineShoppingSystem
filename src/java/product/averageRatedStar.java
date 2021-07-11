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
    private float avergaeStar;
    private int categoryID;

    public averageRatedStar() {
    }

    public averageRatedStar(float avergaeStar, int categoryID) {
        this.avergaeStar = avergaeStar;
        this.categoryID = categoryID;
    }

    public float getAvergaeStar() {
        return avergaeStar;
    }

    public void setAvergaeStar(float avergaeStar) {
        this.avergaeStar = avergaeStar;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    
}
