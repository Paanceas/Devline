/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Empleado;
import co.com.devline.eo.Proyecto;
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
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;
    private List<Proyecto> lista;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //maestro Detalle consulta
    @EJB
    private EmpleadoFacade empleadoFacade;

   

    public ProyectoFacade() {
        super(Proyecto.class);
    }
//borrado Logico
    public List<Proyecto> listarProyecto() {
        lista = em.createNamedQuery("Proyecto.findAll").getResultList();
        return lista;
    }

    public void borrado(Proyecto proyecto) {
        try {
            int query = em.createQuery("UPDATE Proyecto p SET p.eliminar = 1 WHERE p.idProyecto = :id").setParameter("id", proyecto.getIdProyecto()).executeUpdate();
        } catch (Exception e) {
            System.out.println("error en el borrado logico de proyecto");
            e.printStackTrace();
        }

    }

    //maestroDetalleConsulta
    public List<Empleado> obtenerEmpleadosXProyecto(Proyecto proyecto) {
        return empleadoFacade.getListaEmpleadosXIdProyecto(proyecto.getIdProyecto());
    }
    
    
    //ajax count proveedor
     public Long cantProyectos() {
        String query;
        Long count = null;
        try {
            query = "SELECT COUNT(p) FROM Proyecto p";
            count = (Long) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el Query de Login de cantProyectos");
            e.printStackTrace();
        }
        return count;
    }
    
    public List<Proyecto> getLista() {
        return lista;
    }

    public void setLista(List<Proyecto> lista) {
        this.lista = lista;
    }


}
