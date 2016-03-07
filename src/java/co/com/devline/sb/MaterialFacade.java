/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Material;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class MaterialFacade extends AbstractFacade<Material> {

    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialFacade() {
        super(Material.class);
    }
//maestro detalle

    public List<Material> getListaMaterialesXIdAdquisicion(Integer idAdquisicion) {
        try {
            return (List<Material>) em.createQuery("SELECT e FROM Material e, MaterialHasAdquisicion p WHERE e.idMaterial = p.idMaterial.idMaterial and p.idAdquisicion.idAdquisicion = :idAdquisicion").setParameter("idAdquisicion", idAdquisicion).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
//maestro detalle proveedor

    public List<Material> getListaMaterialesXIdCotizacion(Integer idMaterial) {
        try {
            //HACER LA QUERY--------------------------------------------------------
            return (List<Material>) em.createQuery("SELECT m FROM Material m, ProveedorHasMaterial c WHERE m.idMaterial = c.idMaterial.idMaterial AND c.idMaterial.idMaterial = :idMaterial").setParameter("idMaterial", idMaterial).getResultList();
        } catch (Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
        return null;
    }

}
