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
@Table(name = "tipo_uni_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUniMedida.findAll", query = "SELECT t FROM TipoUniMedida t"),
    @NamedQuery(name = "TipoUniMedida.findByIdTipoUniMedida", query = "SELECT t FROM TipoUniMedida t WHERE t.idTipoUniMedida = :idTipoUniMedida"),
    @NamedQuery(name = "TipoUniMedida.findByNombreTipoUniMedida", query = "SELECT t FROM TipoUniMedida t WHERE t.nombreTipoUniMedida = :nombreTipoUniMedida"),
    @NamedQuery(name = "TipoUniMedida.findByAbreviatura", query = "SELECT t FROM TipoUniMedida t WHERE t.abreviatura = :abreviatura")})
public class TipoUniMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_uni_medida")
    private Integer idTipoUniMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_tipo_uni_medida")
    private String nombreTipoUniMedida;
    @Size(max = 15)
    @Column(name = "abreviatura")
    private String abreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUniMedida")
    private Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUniMedida")
    private Collection<Material> materialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUniMedida")
    private Collection<MaterialHasAdquisicion> materialHasAdquisicionCollection;

    public TipoUniMedida() {
    }

    public TipoUniMedida(Integer idTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
    }

    public TipoUniMedida(Integer idTipoUniMedida, String nombreTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
        this.nombreTipoUniMedida = nombreTipoUniMedida;
    }

    public Integer getIdTipoUniMedida() {
        return idTipoUniMedida;
    }

    public void setIdTipoUniMedida(Integer idTipoUniMedida) {
        this.idTipoUniMedida = idTipoUniMedida;
    }

    public String getNombreTipoUniMedida() {
        return nombreTipoUniMedida;
    }

    public void setNombreTipoUniMedida(String nombreTipoUniMedida) {
        this.nombreTipoUniMedida = nombreTipoUniMedida;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @XmlTransient
    public Collection<CotizacionHasMaterial> getCotizacionHasMaterialCollection() {
        return cotizacionHasMaterialCollection;
    }

    public void setCotizacionHasMaterialCollection(Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection) {
        this.cotizacionHasMaterialCollection = cotizacionHasMaterialCollection;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @XmlTransient
    public Collection<MaterialHasAdquisicion> getMaterialHasAdquisicionCollection() {
        return materialHasAdquisicionCollection;
    }

    public void setMaterialHasAdquisicionCollection(Collection<MaterialHasAdquisicion> materialHasAdquisicionCollection) {
        this.materialHasAdquisicionCollection = materialHasAdquisicionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUniMedida != null ? idTipoUniMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUniMedida)) {
            return false;
        }
        TipoUniMedida other = (TipoUniMedida) object;
        if ((this.idTipoUniMedida == null && other.idTipoUniMedida != null) || (this.idTipoUniMedida != null && !this.idTipoUniMedida.equals(other.idTipoUniMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoUniMedida + "-" + abreviatura;
    }
    
}
