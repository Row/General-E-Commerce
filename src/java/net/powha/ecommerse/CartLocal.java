/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.powha.ecommerse;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author jon
 */
@Local
public interface CartLocal {

    void addProduct(int productId);
    Collection<Product> getProducts();
}
