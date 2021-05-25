/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class OrderDTO implements Serializable{
    private int id;
    private int status;
    private Date orderedDate;
    private int saleMemberId;
    private int customerId;
    private String receiverName;
    private String receiverGender;
    private String receiverAddress;
    private String receiverEmail;
    private String receiverPhone;
    private String note;

    public OrderDTO() {
    }

    public OrderDTO(int id, int status, Date orderedDate, int saleMemberId, int customerId, String receiverName, String receiverGender, String receiverAddress, String receiverEmail, String receiverPhone, String note) {
        this.id = id;
        this.status = status;
        this.orderedDate = orderedDate;
        this.saleMemberId = saleMemberId;
        this.customerId = customerId;
        this.receiverName = receiverName;
        this.receiverGender = receiverGender;
        this.receiverAddress = receiverAddress;
        this.receiverEmail = receiverEmail;
        this.receiverPhone = receiverPhone;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public int getSaleMemberId() {
        return saleMemberId;
    }

    public void setSaleMemberId(int saleMemberId) {
        this.saleMemberId = saleMemberId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverGender() {
        return receiverGender;
    }

    public void setReceiverGender(String receiverGender) {
        this.receiverGender = receiverGender;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
