/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Material;
import co.com.devline.eo.Proveedor;
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
public class ProveedorFacade extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;
    private List<Proveedor> lista;
    private Proveedor proveedor;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @EJB
    private MaterialFacade materialFacade;

    public ProveedorFacade() {
        super(Proveedor.class);
    }

    public List<Proveedor> listarEmpleados() {
        lista = em.createNamedQuery("Proveedor.findAll").getResultList();
        return lista;
    }

    public void borrar(Proveedor proveedor) {
        try {
            int query = em.createQuery("UPDATE Proveedor p SET p.eliminar = 1 WHERE p.idProveedor = :id ").setParameter("id", proveedor.getIdProveedor()).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el borrado Logico de Proveedor");
            e.printStackTrace();
        }
    }

    //ajax count proveedor
    public Long cantProveedores() {
        String query;
        Long count = null;
        try {
            query = "SELECT COUNT(p) FROM Proveedor p";
            count = (Long) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el Query de Login de cantProveedores");
            e.printStackTrace();
        }
        return count;
    }
    
    //maestro detalle
    public List<Material> obtenerMaterialesXProveedor(Proveedor proveedor) {
        return materialFacade.getListaMaterialesXIdCotizacion(proveedor.getIdProveedor());
    }
}