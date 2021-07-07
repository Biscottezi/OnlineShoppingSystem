/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedBackAttachedImage;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class FeedBackAttachedImageDTO implements Serializable{
    private int id;
    private String name;
    private int feedbackId;
    
    public FeedBackAttachedImageDTO() {
    }

    public FeedBackAttachedImageDTO(int id, String name, int feedbackId) {
        this.id = id;
        this.name = name;
        this.feedbackId = feedbackId;
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
    
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }
}
