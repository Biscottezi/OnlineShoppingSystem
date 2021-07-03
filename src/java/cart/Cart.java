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
    private Map<ProductDTO,Integer> items;

    public Map<ProductDTO, Integer> getItems() {
        return items;
    }
    
    public void addToCart(int ID, int quantity) throws SQLException, NamingException {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        ProductDAO  dao = new ProductDAO();
        dao.searchProductByID(ID);
        ProductDTO dto= dao.getProduct();
        //3. updtae producct in cart
        this.items.put(dto, quantity);

    }

    public void removeFromCart(int ID) throws SQLException, NamingException {
        //1. Check existing cart
        ProductDAO  dao = new ProductDAO(); 
        dao.searchProductByID(ID);
        ProductDTO dto = dao.getProduct();
        if (this.items == null) {
            return;
        } else //2. Check existing item
        {
            if (this.items.containsKey(dto)) {
                this.items.remove(dto);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }

        }
    }
}
