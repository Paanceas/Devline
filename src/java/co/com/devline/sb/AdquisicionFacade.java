/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.sb;

import co.com.devline.eo.Adquisicion;
import co.com.devline.eo.Material;
import co.com.devline.eo.Proveedor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    //ultimo registro de la adquisicon
    public int ultimaAdquisicion() {
        try {
            int adquisicion = (int) em.createQuery("SELECT MAX(a.idAdquisicion) FROM Adquisicion a").getSingleResult();
            return adquisicion;
        } catch (Exception e) {
            System.out.println("error al consultar la ultima adquisción");
            e.printStackTrace();
        }
        return 0;
    }

    //Registrar el material y el detalle del material con el proveedor

    public void RegistrarMaterialYTablasHas(List<Material> materiales, List<Proveedor> proveedores, int IdAdquisicion) {

        try {
            for (int i = 0; i < materiales.size(); i++) {

                Material mat = materiales.get(i);
                Proveedor pro = proveedores.get(i);
                System.out.println("Material: " + mat.getNombreMaterial());
                System.out.println("Proveedor: " + pro.getIdProveedor());
                List<Material> verificacion = (List<Material>) em.createQuery("SELECT m FROM Material m WHERE m.codigoMaterial = :codigo").setParameter("codigo", mat.getCodigoMaterial()).getResultList();
                if (verificacion != null) {
                    Query sql = null;
                    //llamado al procedure e inserciond de los parametros
                    sql = em.createNativeQuery("{call registrarMaterial(:categoria,:tum,:codMaterial,:nomMaterial,:preUni,:canTo,:desMat)}");
                    sql.setParameter("categoria", mat.getIdCategoria());
                    sql.setParameter("tum", mat.getIdTipoUniMedida());
                    sql.setParameter("codMaterial", mat.getCodigoMaterial());
                    sql.setParameter("nomMaterial", mat.getNombreMaterial());
                    sql.setParameter("preUni", mat.getPrecioUnitario());
                    sql.setParameter("canTo", mat.getCantidadTotal());
                    sql.setParameter("desMat", mat.getDescripcionMaterial());
                    sql.executeUpdate();
                    //ultimo material registrado
                    int ultimoMaterial = (int) em.createQuery("SELECT MAX(m.idMaterial) FROM Material m").getSingleResult();
                    System.out.println(ultimoMaterial + "Es el ultimo material");
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Adquisicion", "Registrada Correctamente"));
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                } else {
                     FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Error", "al Registrar aDQUSICION"));
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR EN EL QUERY DE RegistrarMaterialYTablasHas");
            e.printStackTrace();
        }

    }
}
