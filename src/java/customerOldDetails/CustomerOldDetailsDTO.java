/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerOldDetails;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class CustomerOldDetailsDTO implements Serializable{
    private int oldId;
    private String name;
    private int gender;
    private String address;
    private String phone;
    private Date createdDate;
    private int customerId;

    public CustomerOldDetailsDTO() {
    }

    public CustomerOldDetailsDTO(int oldId, String name, int gender, String address, String phone, Date createdDate, int customerId) {
        this.oldId = oldId;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.createdDate = createdDate;
        this.customerId = customerId;
    }

    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
}
