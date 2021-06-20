/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class Cart implements Serializable{
    private Map<Integer, Integer> items;
    
    public Map<Integer, Integer> getItems() {
        return items;
    }
    
    public void addToCart(int ID, int quantity) throws SQLException, NamingException {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        if (this.items.containsKey(ID)) {
            quantity = this.items.get(ID) + quantity;
        }
        //3. updtae producct in cart
        this.items.put(ID, quantity);

    }

    public void removeFromCart(int ID) throws SQLException, NamingException {
        //1. Check existing cart
        if (this.items == null) {
            return;
        } else //2. Check existing item
        {
            if (this.items.containsKey(ID)) {
                this.items.remove(ID);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }

        }
    }
}
