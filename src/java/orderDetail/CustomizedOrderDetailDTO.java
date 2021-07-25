/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class CustomizedOrderDetailDTO implements Serializable{
    private int orderId;
    private int productId;
    private int quantity;
    private int proCategoryId;
    private String productName;
    private float listPrice;
    private float salePrice;
    private float detailTotal;
    private String thumbnail;

    public CustomizedOrderDetailDTO(int orderId, int productId, int quantity, String productName, String thumbnail, float listPrice, float salePrice, int proCategoryId) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.thumbnail = thumbnail;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        if(salePrice != 0){
            this.detailTotal = salePrice * quantity;
        }
        else{
            this.detailTotal = listPrice * quantity;
        }
        this.proCategoryId = proCategoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getDetailTotal() {
        return detailTotal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getProCategoryId() {
        return proCategoryId;
    }

    public void setProCategoryId(int proCategoryId) {
        this.proCategoryId = proCategoryId;
    }
    
}
