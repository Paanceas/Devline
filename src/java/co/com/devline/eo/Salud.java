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
@Table(name = "salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salud.findAll", query = "SELECT s FROM Salud s"),
    @NamedQuery(name = "Salud.findByIdSalud", query = "SELECT s FROM Salud s WHERE s.idSalud = :idSalud"),
    @NamedQuery(name = "Salud.findByTipoSalud", query = "SELECT s FROM Salud s WHERE s.tipoSalud = :tipoSalud")})
public class Salud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salud")
    private Integer idSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_salud")
    private String tipoSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalud")
    private Collection<Empleado> empleadoCollection;

    public Salud() {
    }

    public Salud(Integer idSalud) {
        this.idSalud = idSalud;
    }

    public Salud(Integer idSalud, String tipoSalud) {
        this.idSalud = idSalud;
        this.tipoSalud = tipoSalud;
    }

    public Integer getIdSalud() {
        return idSalud;
    }

    public void setIdSalud(Integer idSalud) {
        this.idSalud = idSalud;
    }

    public String getTipoSalud() {
        return tipoSalud;
    }

    public void setTipoSalud(String tipoSalud) {
        this.tipoSalud = tipoSalud;
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
        hash += (idSalud != null ? idSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salud)) {
            return false;
        }
        Salud other = (Salud) object;
        if ((this.idSalud == null && other.idSalud != null) || (this.idSalud != null && !this.idSalud.equals(other.idSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoSalud;
    }
    
}
