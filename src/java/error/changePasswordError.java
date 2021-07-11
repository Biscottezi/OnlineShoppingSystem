/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class changePasswordError implements Serializable{
    private String oldPassErr;
    private String newPassErr;
    private String confirmPassErr;

    public changePasswordError() {
        this.oldPassErr = null;
        this.newPassErr = null;
        this.confirmPassErr = null;
    }

    public String getOldPassErr() {
        return oldPassErr;
    }

    public void setOldPassErr(String oldPassErr) {
        this.oldPassErr = oldPassErr;
    }

    public String getNewPassErr() {
        return newPassErr;
    }

    public void setNewPassErr(String newPassErr) {
        this.newPassErr = newPassErr;
    }

    public String getConfirmPassErr() {
        return confirmPassErr;
    }

    public void setConfirmPassErr(String confirmPassErr) {
        this.confirmPassErr = confirmPassErr;
    }
    
    
}
