/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedBackImage;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class FeedBackImageDTO implements Serializable{
    private int feedbackID;
    private int imageID;

    public FeedBackImageDTO() {
    }

    public FeedBackImageDTO(int feedbackID, int imageID) {
        this.feedbackID = feedbackID;
        this.imageID = imageID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    
    
}
