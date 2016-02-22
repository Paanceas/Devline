/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.eo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "cotizacion_has_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotizacionHasMaterial.findAll", query = "SELECT c FROM CotizacionHasMaterial c"),
    @NamedQuery(name = "CotizacionHasMaterial.findByIdCotizacionHasMaterial", query = "SELECT c FROM CotizacionHasMaterial c WHERE c.idCotizacionHasMaterial = :idCotizacionHasMaterial"),
    @NamedQuery(name = "CotizacionHasMaterial.findByPrecio", query = "SELECT c FROM CotizacionHasMaterial c WHERE c.precio = :precio"),
    @NamedQuery(name = "CotizacionHasMaterial.findByCantidad", query = "SELECT c FROM CotizacionHasMaterial c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CotizacionHasMaterial.findByDescripcion", query = "SELECT c FROM CotizacionHasMaterial c WHERE c.descripcion = :descripcion")})
public class CotizacionHasMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotizacion_has_material")
    private Integer idCotizacionHasMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_cotizacion", referencedColumnName = "id_cotizacion")
    @ManyToOne(optional = false)
    private Cotizacion idCotizacion;
    @JoinColumn(name = "id_material", referencedColumnName = "id_material")
    @ManyToOne(optional = false)
    private Material idMaterial;
    @JoinColumn(name = "id_tipo_uni_medida", referencedColumnName = "id_tipo_uni_medida")
    @ManyToOne(optional = false)
    private TipoUniMedida idTipoUniMedida;

    public CotizacionHasMaterial() {
    }

    public CotizacionHasMaterial(Integer idCotizacionHasMaterial) {
        this.idCotizacionHasMaterial = idCotizacionHasMaterial;
    }

    public CotizacionHasMaterial(Integer idCotizacionHasMaterial, int precio, int cantidad) {
        this.idCotizacionHasMaterial = idCotizacionHasMaterial;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdCotizacionHasMaterial() {
        return idCotizacionHasMaterial;
    }

    public void setIdCotizacionHasMaterial(Integer idCotizacionHasMaterial) {
        this.idCotizacionHasMaterial = idCotizacionHasMaterial;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public TipoUniMedida getIdTipoUniMedida() {
        return idTipoUniMedida;
    }

    public void setIdTipoUniMedida(TipoUniMedida idTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacionHasMaterial != null ? idCotizacionHasMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionHasMaterial)) {
            return false;
        }
        CotizacionHasMaterial other = (CotizacionHasMaterial) object;
        if ((this.idCotizacionHasMaterial == null && other.idCotizacionHasMaterial != null) || (this.idCotizacionHasMaterial != null && !this.idCotizacionHasMaterial.equals(other.idCotizacionHasMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.CotizacionHasMaterial[ idCotizacionHasMaterial=" + idCotizacionHasMaterial + " ]";
    }
    
}
