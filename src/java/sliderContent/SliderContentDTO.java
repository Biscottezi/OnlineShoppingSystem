/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliderContent;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class SliderContentDTO implements Serializable{
    private int sliderId;
    private int productId;

    public SliderContentDTO() {
    }

    public SliderContentDTO(int sliderId, int productId) {
        this.sliderId = sliderId;
        this.productId = productId;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
}
