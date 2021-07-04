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
import product.ProductDAO;
import product.ProductDTO;

/**
 *
 * @author ASUS
 */
public class Cart implements Serializable{
    private Map<Integer, ProductDTO> items;

    public Map<Integer, ProductDTO> getItems() {
        return items;
    }
    
    public void addToCart(int ID, int quantity) throws SQLException, NamingException {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        
        ProductDTO dto = new ProductDTO();
        //3. updtae producct in cart
        if(this.items.containsKey(ID)){
            dto = this.items.get(ID);
            dto.setQuantity(quantity);
        }else{
            ProductDAO  dao = new ProductDAO();
            dao.searchProductByID(ID);
            dto = dao.getProduct();
            dto.setQuantity(quantity);
        }
        this.items.put(ID, dto);
    }

    public void removeFromCart(int ID) throws SQLException, NamingException {
        //1. Check existing cart
        
        if (this.items == null) {
            return;
        } else {
                if (this.items.containsKey(ID)) {
                this.items.remove(ID);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }
        }
    }
}
