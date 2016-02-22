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
@Table(name = "material_has_adquisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialHasAdquisicion.findAll", query = "SELECT m FROM MaterialHasAdquisicion m"),
    @NamedQuery(name = "MaterialHasAdquisicion.findByIdMaterialHasAdquisicion", query = "SELECT m FROM MaterialHasAdquisicion m WHERE m.idMaterialHasAdquisicion = :idMaterialHasAdquisicion")})
public class MaterialHasAdquisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_has_adquisicion")
    private Integer idMaterialHasAdquisicion;
    @JoinColumn(name = "id_tipo_uni_medida", referencedColumnName = "id_tipo_uni_medida")
    @ManyToOne(optional = false)
    private TipoUniMedida idTipoUniMedida;
    @JoinColumn(name = "id_material", referencedColumnName = "id_material")
    @ManyToOne(optional = false)
    private Material idMaterial;
    @JoinColumn(name = "id_adquisicion", referencedColumnName = "id_adquisicion")
    @ManyToOne(optional = false)
    private Adquisicion idAdquisicion;

    public MaterialHasAdquisicion() {
    }

    public MaterialHasAdquisicion(Integer idMaterialHasAdquisicion) {
        this.idMaterialHasAdquisicion = idMaterialHasAdquisicion;
    }

    public Integer getIdMaterialHasAdquisicion() {
        return idMaterialHasAdquisicion;
    }

    public void setIdMaterialHasAdquisicion(Integer idMaterialHasAdquisicion) {
        this.idMaterialHasAdquisicion = idMaterialHasAdquisicion;
    }

    public TipoUniMedida getIdTipoUniMedida() {
        return idTipoUniMedida;
    }

    public void setIdTipoUniMedida(TipoUniMedida idTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Adquisicion getIdAdquisicion() {
        return idAdquisicion;
    }

    public void setIdAdquisicion(Adquisicion idAdquisicion) {
        this.idAdquisicion = idAdquisicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialHasAdquisicion != null ? idMaterialHasAdquisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialHasAdquisicion)) {
            return false;
        }
        MaterialHasAdquisicion other = (MaterialHasAdquisicion) object;
        if ((this.idMaterialHasAdquisicion == null && other.idMaterialHasAdquisicion != null) || (this.idMaterialHasAdquisicion != null && !this.idMaterialHasAdquisicion.equals(other.idMaterialHasAdquisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.MaterialHasAdquisicion[ idMaterialHasAdquisicion=" + idMaterialHasAdquisicion + " ]";
    }
    
}
