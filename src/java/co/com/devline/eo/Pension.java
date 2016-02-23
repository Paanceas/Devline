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
@Table(name = "pension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pension.findAll", query = "SELECT p FROM Pension p"),
    @NamedQuery(name = "Pension.findByIdPension", query = "SELECT p FROM Pension p WHERE p.idPension = :idPension"),
    @NamedQuery(name = "Pension.findByNombrePension", query = "SELECT p FROM Pension p WHERE p.nombrePension = :nombrePension")})
public class Pension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pension")
    private Integer idPension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_pension")
    private String nombrePension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPension")
    private Collection<Empleado> empleadoCollection;

    public Pension() {
    }

    public Pension(Integer idPension) {
        this.idPension = idPension;
    }

    public Pension(Integer idPension, String nombrePension) {
        this.idPension = idPension;
        this.nombrePension = nombrePension;
    }

    public Integer getIdPension() {
        return idPension;
    }

    public void setIdPension(Integer idPension) {
        this.idPension = idPension;
    }

    public String getNombrePension() {
        return nombrePension;
    }

    public void setNombrePension(String nombrePension) {
        this.nombrePension = nombrePension;
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
        hash += (idPension != null ? idPension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pension)) {
            return false;
        }
        Pension other = (Pension) object;
        if ((this.idPension == null && other.idPension != null) || (this.idPension != null && !this.idPension.equals(other.idPension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePension;
    }
    
}
