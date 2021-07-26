/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.util.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;  
import javax.mail.internet.*;  
/**
 *
 * @author ASUS
 */
public class sendMail implements Serializable{
    
    private final static String WEB_URL = "http://localhost:8084/OnlineShoppingSystem/";
    
    public static void mailCreatedUser(String recipient, String password){
        try {
            Properties prop = new Properties();
            
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            
            String myAcc = "onlineshoppingsystemswp391@gmail.com";
            String pass = "onlineShoppingSystemSWP391.";
            
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAcc, pass);
                }
            });
            
            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(myAcc));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("New account from OnlineShoppingSystem");
                String htmlCode = "<h2>Your Account</h2></br>"
                        + "<div>Username: " + recipient + "</div></br>"
                        + "<div>Password: " + password + "</div></br>"
                        + "<a href=" + WEB_URL + ">Link to our web</a>";
                message.setContent(htmlCode, "text/html");
            }catch(MessagingException ex){
                Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mailResetLink(String recipient, int UserID){
        try {
            String resetLink = "http://localhost:8084/OnlineShoppingSystem/resetPage?userID=" + UserID;
            Properties prop = new Properties();
            
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            
            String myAcc = "onlineshoppingsystemswp391@gmail.com";
            String pass = "onlineShoppingSystemSWP391.";
            
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAcc, pass);
                }
            });
            
            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(myAcc));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Reset account from OnlineShoppingSystem");
                String htmlCode = "<h2>Here is your link to set new password</h2></br>"
                        + "<a href=" + resetLink + ">Click here!</a>";
                message.setContent(htmlCode, "text/html");
            }catch(MessagingException ex){
                Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void mailCheckout(String recipient, int OrderID){
        try {
            
            Properties prop = new Properties();
            
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            
            String myAcc = "onlineshoppingsystemswp391@gmail.com";
            String pass = "onlineShoppingSystemSWP391.";
            
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAcc, pass);
                }
            });
            
            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(myAcc));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Order placed from OnlineShoppingSystem");
                String htmlCode = "<h2>Your Order "+ OrderID +" is submitted .Please wait for confirming by our shop! </h2></br>";
                        
                message.setContent(htmlCode, "text/html");
            }catch(MessagingException ex){
                Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void mailConfirmOrder(String recipient, int OrderID){
        try {
            String confirmLink = "http://localhost:8084/OnlineShoppingSystem/custOrderDetail?orderID=" + OrderID;
            Properties prop = new Properties();
            
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            
            String myAcc = "onlineshoppingsystemswp391@gmail.com";
            String pass = "onlineShoppingSystemSWP391.";
            
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAcc, pass);
                }
            });
            
            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(myAcc));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Order confirmation from OnlineShoppingSystem");
                String htmlCode = "<h2>Your Order "+ OrderID +" is confirmed . Thank you for your Purchase!</h2></br>"
                        +"<a href=" + confirmLink + ">Click here to view your order!</a>";
                        
                message.setContent(htmlCode, "text/html");
            }catch(MessagingException ex){
                Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void mailShippedOrder(String recipient, int ProductID, String productName){
        try {
            String feedbackLink = "http://localhost:8084/OnlineShoppingSystem/custFeedback?productID=" + ProductID;
            Properties prop = new Properties();
            
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            
            String myAcc = "onlineshoppingsystemswp391@gmail.com";
            String pass = "onlineShoppingSystemSWP391.";
            
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAcc, pass);
                }
            });
            
            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(myAcc));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Order is shipped OnlineShoppingSystem");
                String htmlCode = "<h2>Your is now shipping! </h2></br>"
                        +"<a href=" + feedbackLink + ">Click here to enter your feedback for "+productName+"!</a>";
                        
                message.setContent(htmlCode, "text/html");
            }catch(MessagingException ex){
                Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
