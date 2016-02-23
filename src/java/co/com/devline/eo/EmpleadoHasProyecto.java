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
@Table(name = "empleado_has_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoHasProyecto.findAll", query = "SELECT e FROM EmpleadoHasProyecto e"),
    @NamedQuery(name = "EmpleadoHasProyecto.findByIdEmpleadoHasProyecto", query = "SELECT e FROM EmpleadoHasProyecto e WHERE e.idEmpleadoHasProyecto = :idEmpleadoHasProyecto")})
public class EmpleadoHasProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado_has_proyecto")
    private Integer idEmpleadoHasProyecto;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public EmpleadoHasProyecto() {
    }

    public EmpleadoHasProyecto(Integer idEmpleadoHasProyecto) {
        this.idEmpleadoHasProyecto = idEmpleadoHasProyecto;
    }

    public Integer getIdEmpleadoHasProyecto() {
        return idEmpleadoHasProyecto;
    }

    public void setIdEmpleadoHasProyecto(Integer idEmpleadoHasProyecto) {
        this.idEmpleadoHasProyecto = idEmpleadoHasProyecto;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleadoHasProyecto != null ? idEmpleadoHasProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoHasProyecto)) {
            return false;
        }
        EmpleadoHasProyecto other = (EmpleadoHasProyecto) object;
        if ((this.idEmpleadoHasProyecto == null && other.idEmpleadoHasProyecto != null) || (this.idEmpleadoHasProyecto != null && !this.idEmpleadoHasProyecto.equals(other.idEmpleadoHasProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEmpleadoHasProyecto + " " + idProyecto.getNombreProyecto();
    }
    
}
