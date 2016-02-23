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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "proveedor_has_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorHasMaterial.findAll", query = "SELECT p FROM ProveedorHasMaterial p"),
    @NamedQuery(name = "ProveedorHasMaterial.findByIdProveedorHasMaterial", query = "SELECT p FROM ProveedorHasMaterial p WHERE p.idProveedorHasMaterial = :idProveedorHasMaterial")})
public class ProveedorHasMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor_has_material")
    private Integer idProveedorHasMaterial;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "id_material", referencedColumnName = "id_material")
    @ManyToOne(optional = false)
    private Material idMaterial;

    public ProveedorHasMaterial() {
    }

    public ProveedorHasMaterial(Integer idProveedorHasMaterial) {
        this.idProveedorHasMaterial = idProveedorHasMaterial;
    }

    public Integer getIdProveedorHasMaterial() {
        return idProveedorHasMaterial;
    }

    public void setIdProveedorHasMaterial(Integer idProveedorHasMaterial) {
        this.idProveedorHasMaterial = idProveedorHasMaterial;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedorHasMaterial != null ? idProveedorHasMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorHasMaterial)) {
            return false;
        }
        ProveedorHasMaterial other = (ProveedorHasMaterial) object;
        if ((this.idProveedorHasMaterial == null && other.idProveedorHasMaterial != null) || (this.idProveedorHasMaterial != null && !this.idProveedorHasMaterial.equals(other.idProveedorHasMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idProveedorHasMaterial + " " + idProveedor.getNombre();
    }
    
}
