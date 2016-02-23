/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.eo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdMaterial", query = "SELECT m FROM Material m WHERE m.idMaterial = :idMaterial"),
    @NamedQuery(name = "Material.findByCodigoMaterial", query = "SELECT m FROM Material m WHERE m.codigoMaterial = :codigoMaterial"),
    @NamedQuery(name = "Material.findByNombreMaterial", query = "SELECT m FROM Material m WHERE m.nombreMaterial = :nombreMaterial"),
    @NamedQuery(name = "Material.findByPrecioUnitario", query = "SELECT m FROM Material m WHERE m.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Material.findByCantidadTotal", query = "SELECT m FROM Material m WHERE m.cantidadTotal = :cantidadTotal"),
    @NamedQuery(name = "Material.findByDescripcionMaterial", query = "SELECT m FROM Material m WHERE m.descripcionMaterial = :descripcionMaterial")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material")
    private Integer idMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo_material")
    private String codigoMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_material")
    private String nombreMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private int precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_total")
    private int cantidadTotal;
    @Size(max = 500)
    @Column(name = "descripcion_material")
    private String descripcionMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
    private Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection;
    @JoinColumn(name = "id_tipo_uni_medida", referencedColumnName = "id_tipo_uni_medida")
    @ManyToOne(optional = false)
    private TipoUniMedida idTipoUniMedida;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
    private Collection<MaterialHasAdquisicion> materialHasAdquisicionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
    private Collection<ProveedorHasMaterial> proveedorHasMaterialCollection;

    public Material() {
    }

    public Material(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material(Integer idMaterial, String codigoMaterial, String nombreMaterial, int precioUnitario, int cantidadTotal) {
        this.idMaterial = idMaterial;
        this.codigoMaterial = codigoMaterial;
        this.nombreMaterial = nombreMaterial;
        this.precioUnitario = precioUnitario;
        this.cantidadTotal = cantidadTotal;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getDescripcionMaterial() {
        return descripcionMaterial;
    }

    public void setDescripcionMaterial(String descripcionMaterial) {
        this.descripcionMaterial = descripcionMaterial;
    }

    @XmlTransient
    public Collection<CotizacionHasMaterial> getCotizacionHasMaterialCollection() {
        return cotizacionHasMaterialCollection;
    }

    public void setCotizacionHasMaterialCollection(Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection) {
        this.cotizacionHasMaterialCollection = cotizacionHasMaterialCollection;
    }

    public TipoUniMedida getIdTipoUniMedida() {
        return idTipoUniMedida;
    }

    public void setIdTipoUniMedida(TipoUniMedida idTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<MaterialHasAdquisicion> getMaterialHasAdquisicionCollection() {
        return materialHasAdquisicionCollection;
    }

    public void setMaterialHasAdquisicionCollection(Collection<MaterialHasAdquisicion> materialHasAdquisicionCollection) {
        this.materialHasAdquisicionCollection = materialHasAdquisicionCollection;
    }

    @XmlTransient
    public Collection<ProveedorHasMaterial> getProveedorHasMaterialCollection() {
        return proveedorHasMaterialCollection;
    }

    public void setProveedorHasMaterialCollection(Collection<ProveedorHasMaterial> proveedorHasMaterialCollection) {
        this.proveedorHasMaterialCollection = proveedorHasMaterialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMaterial + " " + codigoMaterial;
    }
    
}
