/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;
     private List<Cliente> lista;
    private Cliente cliente;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
     public List<Cliente> listarClientes(){
        
        lista = em.createNamedQuery("Cliente.findAll").getResultList();
        return lista;
    }
    public void borrar(Cliente cliente){
        try {
            int query = em.createQuery("UPDATE Cliente c SET c.eliminar = 1 WHERE c.idCliente = :id").setParameter("id", cliente.getIdCliente()).executeUpdate();
        } catch (Exception e) {
            System.out.println("error al hacer borrado lógico cliente");
            e.printStackTrace();
        }
    }
    //ajax count cliente
     public Long cantClientes() {
        String query;
        Long count = null;
        try {
            query = "SELECT COUNT(c) FROM Cliente c";
            count = (Long) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el Query de Login de cantClientes");
            e.printStackTrace();
        }
        return count;
    }
    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
