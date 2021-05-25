/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class PostDTO implements Serializable{
    private int id;
    private String title;
    private String thumbnail;
    private String briefInfo;
    private String author;
    private String description;
    private int featured;
    private int status;
    private int postCategoryId;
    private Date createdDate;

    public PostDTO() {
    }

    public PostDTO(int id, String title, String thumbnail, String briefInfo, String author, String description, int featured, int status, int postCategoryId, Date createdDate) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.briefInfo = briefInfo;
        this.author = author;
        this.description = description;
        this.featured = featured;
        this.status = status;
        this.postCategoryId = postCategoryId;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(int postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
}
