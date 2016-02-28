/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Cliente;
import co.com.devline.eo.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {
    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;
    private List<Empleado> lista;
    private Empleado empleado;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public List<Empleado> listarEmpleados(){
        lista = em.createNamedQuery("Empleado.findAll").getResultList();
        return lista;
    }
    public void borrar(Empleado empleado){
        try {
            int query = em.createQuery("UPDATE Empleado e SET e.eliminar = 1 WHERE e.idEmpleado = :id").setParameter("id", empleado.getIdEmpleado()).executeUpdate();
        } catch (Exception e) {
            System.out.println("error al hacer borrado lógico cliente");
            e.printStackTrace();
        }
    }
    public EmpleadoFacade() {
        super(Empleado.class);
    }
    //ajax cont empelado
    public Long cantEmpleados() {
        String query;
        Long count = null;
        try {
            query = "SELECT COUNT(e) FROM Empleado e";
            count = (Long) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el Query de Login de cantEmpleados");
            e.printStackTrace();
        }
        return count;
    }
    
    

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleadosXIdProyecto(Integer idProyecto) {
        try {
            return (List<Empleado>) em.createQuery("SELECT e FROM Empleado e, EmpleadoHasProyecto p WHERE e.idEmpleado = p.idEmpleado.idEmpleado and p.idProyecto.idProyecto = :idProyecto").setParameter("idProyecto", idProyecto).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
