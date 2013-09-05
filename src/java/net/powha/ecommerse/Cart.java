/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.powha.ecommerse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.Stateful;

/**
 *
 * @author jon
 */
@Stateful
public class Cart implements CartLocal {

    private Collection<Product> productCollection;
    private String customerName;
    
    public void initialize(String person) {
        if (person == null) {
            
        } else {
            customerName = person;
        }

        productCollection = new ArrayList<Product>();
    }
    
    @Override
    public void addProduct(int productId) {
        
    }
    
   @Override
   public Collection<Product> getProducts() {
        return productCollection;   
   }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
