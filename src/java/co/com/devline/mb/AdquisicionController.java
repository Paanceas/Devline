package co.com.devline.mb;

import co.com.devline.eo.Adquisicion;
import co.com.devline.eo.Material;
import co.com.devline.eo.MaterialHasAdquisicion;
import co.com.devline.eo.Proveedor;
import co.com.devline.eo.ProveedorHasMaterial;
import co.com.devline.mb.util.JsfUtil;
import co.com.devline.mb.util.JsfUtil.PersistAction;
import co.com.devline.sb.AdquisicionFacade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "adquisicionController")
@SessionScoped
public class AdquisicionController implements Serializable {

    @EJB
    private co.com.devline.sb.AdquisicionFacade ejbFacade;
    private List<Adquisicion> items = null;
    private Adquisicion selected = new Adquisicion();
    private Material material = new Material();
    private Proveedor proveedor = new Proveedor();
    private List<MaterialHasAdquisicion> ListaAdquisicion = new ArrayList();
    private List<ProveedorHasMaterial> ListaProveedor = new ArrayList();
    private List<Material> listaMateriales = new ArrayList();
    private List<Proveedor> listaProveedores = new ArrayList();
    private int cantidad;

//maestro detalle
    private List<Material> listaMaterialesAdquisicion;
    private Adquisicion adquisicionSeleccionada;

    public AdquisicionController() {
    }
    
    public String convertirFechas(Date fecha){
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    public String prepararMaterial() {
        material = new Material();
        proveedor = new Proveedor();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        return "Adquisicion?faces-redirect=true";
    }

    public void agregar() {
        Proveedor pro = new Proveedor();
        Material mat = new Material();

        pro.setIdProveedor(proveedor.getIdProveedor());
        this.listaProveedores.add(pro);

        mat.setCodigoMaterial(material.getCodigoMaterial());
        mat.setNombreMaterial(material.getNombreMaterial());
        mat.setDescripcionMaterial(material.getDescripcionMaterial());
        mat.setPrecioUnitario(material.getPrecioUnitario());
        mat.setCantidadTotal(material.getCantidadTotal());
        mat.setIdCategoria(material.getIdCategoria());
        mat.setIdTipoUniMedida(material.getIdTipoUniMedida());

        this.listaMateriales.add(mat);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Material Asignado", "Correctamente"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

    }

    public Adquisicion getSelected() {
        return selected;
    }

    public void setSelected(Adquisicion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AdquisicionFacade getFacade() {
        return ejbFacade;
    }

    public Adquisicion prepareCreate() {
        selected = new Adquisicion();
        listaMateriales = new ArrayList();
        ListaProveedor = new ArrayList();

        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AdquisicionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AdquisicionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AdquisicionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Adquisicion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Adquisicion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Adquisicion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<MaterialHasAdquisicion> getListaAdquisicion() {
        return ListaAdquisicion;
    }

    public void setListaAdquisicion(List<MaterialHasAdquisicion> ListaAdquisicion) {
        this.ListaAdquisicion = ListaAdquisicion;
    }

    public List<ProveedorHasMaterial> getListaProveedor() {
        return ListaProveedor;
    }

    public void setListaProveedor(List<ProveedorHasMaterial> ListaProveedor) {
        this.ListaProveedor = ListaProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public List<Material> getListaMaterialesAdquisicion() {
        return listaMaterialesAdquisicion;
    }

    public void setListaMaterialesAdquisicion(List<Material> listaMaterialesAdquisicion) {
        this.listaMaterialesAdquisicion = listaMaterialesAdquisicion;
    }

    public Adquisicion getAdquisicionSeleccionada() {
        return adquisicionSeleccionada;
    }

    public void setAdquisicionSeleccionada(Adquisicion adquisicionSeleccionada) {
        this.adquisicionSeleccionada = adquisicionSeleccionada;
    }

    @FacesConverter(forClass = Adquisicion.class)
    public static class AdquisicionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AdquisicionController controller = (AdquisicionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "adquisicionController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Adquisicion) {
                Adquisicion o = (Adquisicion) object;
                return getStringKey(o.getIdAdquisicion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Adquisicion.class.getName()});
                return null;
            }
        }

    }
    //maestro detalle
    public void cargarMateriales(ValueChangeEvent value) {
        adquisicionSeleccionada = (Adquisicion) value.getNewValue();
        listaMateriales = ejbFacade.obtenerMaterialesXIdAdquisicion(adquisicionSeleccionada);
    }

}
