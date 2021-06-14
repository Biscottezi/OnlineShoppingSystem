/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class CustomerError implements Serializable{
    private String emailError;
    private String passErr;
    private String confirmpassErr;
    private String fullnameErr;
    private String addressErr;
    private int genderError;
    private String phoneError;

    public CustomerError() {
        this.emailError = null;
        this.passErr = null;
        this.confirmpassErr = null;
        this.fullnameErr = null;
        this.addressErr = null;
        this.genderError = 0;
        this.phoneError = null;
    }

    /**
     * @return the emailError
     */
    public String getEmailError() {
        return emailError;
    }

    /**
     * @param emailError the emailError to set
     */
    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    /**
     * @return the passErr
     */
    public String getPassErr() {
        return passErr;
    }

    /**
     * @param passErr the passErr to set
     */
    public void setPassErr(String passErr) {
        this.passErr = passErr;
    }

    /**
     * @return the confirmpassErr
     */
    public String getConfirmpassErr() {
        return confirmpassErr;
    }

    /**
     * @param confirmpassErr the confirmpassErr to set
     */
    public void setConfirmpassErr(String confirmpassErr) {
        this.confirmpassErr = confirmpassErr;
    }

    /**
     * @return the fullnameErr
     */
    public String getFullnameErr() {
        return fullnameErr;
    }

    /**
     * @param fullnameErr the fullnameErr to set
     */
    public void setFullnameErr(String fullnameErr) {
        this.fullnameErr = fullnameErr;
    }

    /**
     * @return the addressErr
     */
    public String getAddressErr() {
        return addressErr;
    }

    /**
     * @param addressErr the addressErr to set
     */
    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    /**
     * @return the genderError
     */
    public int getGenderError() {
        return genderError;
    }

    /**
     * @param genderError the genderError to set
     */
    public void setGenderError(int genderError) {
        this.genderError = genderError;
    }

    /**
     * @return the phoneError
     */
    public String getPhoneError() {
        return phoneError;
    }

    /**
     * @param phoneError the phoneError to set
     */
    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }
    
    
}
