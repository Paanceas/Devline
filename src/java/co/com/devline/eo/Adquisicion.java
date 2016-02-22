/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.devline.eo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "adquisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adquisicion.findAll", query = "SELECT a FROM Adquisicion a"),
    @NamedQuery(name = "Adquisicion.findByIdAdquisicion", query = "SELECT a FROM Adquisicion a WHERE a.idAdquisicion = :idAdquisicion"),
    @NamedQuery(name = "Adquisicion.findByFechaAdquisicion", query = "SELECT a FROM Adquisicion a WHERE a.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "Adquisicion.findByValorTotalAdquisicion", query = "SELECT a FROM Adquisicion a WHERE a.valorTotalAdquisicion = :valorTotalAdquisicion")})
public class Adquisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adquisicion")
    private Integer idAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total_adquisicion")
    private int valorTotalAdquisicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdquisicion")
    private Collection<MaterialHasAdquisicion> materialHasAdquisicionCollection;

    public Adquisicion() {
    }

    public Adquisicion(Integer idAdquisicion) {
        this.idAdquisicion = idAdquisicion;
    }

    public Adquisicion(Integer idAdquisicion, Date fechaAdquisicion, int valorTotalAdquisicion) {
        this.idAdquisicion = idAdquisicion;
        this.fechaAdquisicion = fechaAdquisicion;
        this.valorTotalAdquisicion = valorTotalAdquisicion;
    }

    public Integer getIdAdquisicion() {
        return idAdquisicion;
    }

    public void setIdAdquisicion(Integer idAdquisicion) {
        this.idAdquisicion = idAdquisicion;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getValorTotalAdquisicion() {
        return valorTotalAdquisicion;
    }

    public void setValorTotalAdquisicion(int valorTotalAdquisicion) {
        this.valorTotalAdquisicion = valorTotalAdquisicion;
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
        hash += (idAdquisicion != null ? idAdquisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adquisicion)) {
            return false;
        }
        Adquisicion other = (Adquisicion) object;
        if ((this.idAdquisicion == null && other.idAdquisicion != null) || (this.idAdquisicion != null && !this.idAdquisicion.equals(other.idAdquisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.Adquisicion[ idAdquisicion=" + idAdquisicion + " ]";
    }
    
}
