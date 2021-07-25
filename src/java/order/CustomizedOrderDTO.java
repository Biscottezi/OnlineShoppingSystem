/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import orderDetail.CustomizedOrderDetailDTO;
import user.UserDTO;

/**
 *
 * @author nguye
 */
public class CustomizedOrderDTO implements Serializable{
    private int orderId;
    private int status;
    private int customerId;
    private int saleMemberId;
    private Date orderedDate;
    private String receiverName;
    private String receiverAddress;
    private String receiverEmail;
    private String receiverPhone;
    private String note;
    private int receiverGender;
    private float total = 0;
    private List<CustomizedOrderDetailDTO> details;
    private int noOfProd;
    private String customerName;
    private UserDTO customer;
    
    public CustomizedOrderDTO(int orderId, int status, int customerId, int saleMemberId, Date orderedDate, String receiverName, String receiverAddress, String receiverEmail, String receiverPhone, String note, int receiverGender) {
        this.orderId = orderId;
        this.status = status;
        this.customerId = customerId;
        this.saleMemberId = saleMemberId;
        this.orderedDate = orderedDate;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverEmail = receiverEmail;
        this.receiverPhone = receiverPhone;
        this.note = note;
        this.receiverGender = receiverGender;
    }

    public CustomizedOrderDTO(int orderId, int status, int customerId, int saleMemberId, Date orderedDate, String receiverName, String receiverAddress, String receiverEmail, String receiverPhone, String note, int receiverGender, String customerName) {
        this.orderId = orderId;
        this.status = status;
        this.customerId = customerId;
        this.saleMemberId = saleMemberId;
        this.orderedDate = orderedDate;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverEmail = receiverEmail;
        this.receiverPhone = receiverPhone;
        this.note = note;
        this.receiverGender = receiverGender;
        this.customerName = customerName;
    }

    public CustomizedOrderDTO(int orderId, int status, int customerId, int saleMemberId, Date orderedDate, String receiverName, String receiverAddress, String receiverEmail, String receiverPhone, String note, int receiverGender, UserDTO customer) {
        this.orderId = orderId;
        this.status = status;
        this.customerId = customerId;
        this.saleMemberId = saleMemberId;
        this.orderedDate = orderedDate;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverEmail = receiverEmail;
        this.receiverPhone = receiverPhone;
        this.note = note;
        this.receiverGender = receiverGender;
        this.customer = customer;
    }

    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSaleMemberId() {
        return saleMemberId;
    }

    public void setSaleMemberId(int saleMemberId) {
        this.saleMemberId = saleMemberId;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public int getReceiverGender() {
        return receiverGender;
    }

    public void setReceiverGender(int receiverGender) {
        this.receiverGender = receiverGender;
    }

    public float getTotal() {
        return total;
    }

    public List<CustomizedOrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<CustomizedOrderDetailDTO> details) {
        this.details = details;
        this.noOfProd = details.size();
        for(int i = 0; i < details.size(); ++i){
            this.total += details.get(i).getDetailTotal();
        }
    }

    public int getNoOfProd() {
        return noOfProd;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }
    
    
}
