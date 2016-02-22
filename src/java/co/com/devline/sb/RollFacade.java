/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Roll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class RollFacade extends AbstractFacade<Roll> {
    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RollFacade() {
        super(Roll.class);
    }
    
}
