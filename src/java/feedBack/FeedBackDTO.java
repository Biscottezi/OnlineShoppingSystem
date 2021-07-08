/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedBack;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class FeedBackDTO implements Serializable{
    private int id;
    private String name;
    private String content;
    private String email;
    private String phone;
    private int status;
    private int ratedStar;
    private int productId;
    private String productTitle;

    public FeedBackDTO() {
    }

    public FeedBackDTO(int id, String name, String content, String email, String phone, int status, int ratedStar, int productId, String productTitle) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.ratedStar = ratedStar;
        this.productId = productId;
        this.productTitle = productTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRatedStar() {
        return ratedStar;
    }

    public void setRatedStar(int ratedStar) {
        this.ratedStar = ratedStar;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
    
    
}
