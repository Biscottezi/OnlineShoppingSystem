/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productAttachedImage;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class ProductAttachedImageDTO implements Serializable{
    private int imageId;
    private String name;
    private String productId;

    public ProductAttachedImageDTO() {
    }

    public ProductAttachedImageDTO(int imageId, String name, String productId) {
        this.imageId = imageId;
        this.name = name;
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    
    
}
