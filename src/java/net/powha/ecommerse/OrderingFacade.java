/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.powha.ecommerse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jon
 */
@Stateless
public class OrderingFacade extends AbstractFacade<Ordering> {
    @PersistenceContext(unitName = "GeneralECommersePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderingFacade() {
        super(Ordering.class);
    }
    
}
