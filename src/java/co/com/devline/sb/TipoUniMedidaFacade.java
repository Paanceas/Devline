/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.TipoUniMedida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class TipoUniMedidaFacade extends AbstractFacade<TipoUniMedida> {
    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUniMedidaFacade() {
        super(TipoUniMedida.class);
    }
    
}
