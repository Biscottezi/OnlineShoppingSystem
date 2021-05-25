/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productImage;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class ProductImageDTO implements Serializable{
    private int productId;
    private int imageId;

    public ProductImageDTO() {
    }

    public ProductImageDTO(int productId, int imageId) {
        this.productId = productId;
        this.imageId = imageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    
}
