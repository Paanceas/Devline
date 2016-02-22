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
@Table(name = "caja_de_compensacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CajaDeCompensacion.findAll", query = "SELECT c FROM CajaDeCompensacion c"),
    @NamedQuery(name = "CajaDeCompensacion.findByIdCajaDeCompensacion", query = "SELECT c FROM CajaDeCompensacion c WHERE c.idCajaDeCompensacion = :idCajaDeCompensacion"),
    @NamedQuery(name = "CajaDeCompensacion.findByNombreCajaDeCompensacion", query = "SELECT c FROM CajaDeCompensacion c WHERE c.nombreCajaDeCompensacion = :nombreCajaDeCompensacion")})
public class CajaDeCompensacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caja_de_compensacion")
    private Integer idCajaDeCompensacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_caja_de_compensacion")
    private String nombreCajaDeCompensacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCajaDeCompensacion")
    private Collection<Empleado> empleadoCollection;

    public CajaDeCompensacion() {
    }

    public CajaDeCompensacion(Integer idCajaDeCompensacion) {
        this.idCajaDeCompensacion = idCajaDeCompensacion;
    }

    public CajaDeCompensacion(Integer idCajaDeCompensacion, String nombreCajaDeCompensacion) {
        this.idCajaDeCompensacion = idCajaDeCompensacion;
        this.nombreCajaDeCompensacion = nombreCajaDeCompensacion;
    }

    public Integer getIdCajaDeCompensacion() {
        return idCajaDeCompensacion;
    }

    public void setIdCajaDeCompensacion(Integer idCajaDeCompensacion) {
        this.idCajaDeCompensacion = idCajaDeCompensacion;
    }

    public String getNombreCajaDeCompensacion() {
        return nombreCajaDeCompensacion;
    }

    public void setNombreCajaDeCompensacion(String nombreCajaDeCompensacion) {
        this.nombreCajaDeCompensacion = nombreCajaDeCompensacion;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCajaDeCompensacion != null ? idCajaDeCompensacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajaDeCompensacion)) {
            return false;
        }
        CajaDeCompensacion other = (CajaDeCompensacion) object;
        if ((this.idCajaDeCompensacion == null && other.idCajaDeCompensacion != null) || (this.idCajaDeCompensacion != null && !this.idCajaDeCompensacion.equals(other.idCajaDeCompensacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.CajaDeCompensacion[ idCajaDeCompensacion=" + idCajaDeCompensacion + " ]";
    }
    
}
