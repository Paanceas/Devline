/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "DevlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario valida(String usuario, String password) {
        try {
            Usuario u = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombre_usuario AND u.clave = :clave ").setParameter("nombre_usuario", usuario).setParameter("clave", password).getSingleResult();
            if (u != null) {
                return u;
            }
        } catch (Exception e) {
            System.out.println("Error en el Query de Login");
            e.printStackTrace();
        }
        return null;
    }

}
