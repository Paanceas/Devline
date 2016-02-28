/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Adquisicion;
import co.com.devline.eo.Material;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class AdquisicionFacade extends AbstractFacade<Adquisicion> {
    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;
    @EJB
    private MaterialFacade materialFacade;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdquisicionFacade() {
        super(Adquisicion.class);
    }
    //maestro detallle
    public List<Material> obtenerMaterialesXIdAdquisicion(Adquisicion adquisicion) {
        return materialFacade.getListaMaterialesXIdAdquisicion(adquisicion.getIdAdquisicion());
    }
}
