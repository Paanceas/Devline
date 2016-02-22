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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByCodigoProyecto", query = "SELECT p FROM Proyecto p WHERE p.codigoProyecto = :codigoProyecto"),
    @NamedQuery(name = "Proyecto.findByDescripcionProyecto", query = "SELECT p FROM Proyecto p WHERE p.descripcionProyecto = :descripcionProyecto"),
    @NamedQuery(name = "Proyecto.findByFechaInicioProyecto", query = "SELECT p FROM Proyecto p WHERE p.fechaInicioProyecto = :fechaInicioProyecto"),
    @NamedQuery(name = "Proyecto.findByFechaFinalProyecto", query = "SELECT p FROM Proyecto p WHERE p.fechaFinalProyecto = :fechaFinalProyecto"),
    @NamedQuery(name = "Proyecto.findByValorAnticipado", query = "SELECT p FROM Proyecto p WHERE p.valorAnticipado = :valorAnticipado"),
    @NamedQuery(name = "Proyecto.findByValorTotalProyecto", query = "SELECT p FROM Proyecto p WHERE p.valorTotalProyecto = :valorTotalProyecto"),
    @NamedQuery(name = "Proyecto.findByEliminar", query = "SELECT p FROM Proyecto p WHERE p.eliminar = :eliminar")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;
    @Size(max = 500)
    @Column(name = "descripcion_proyecto")
    private String descripcionProyecto;
    @Column(name = "fecha_inicio_proyecto")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioProyecto;
    @Column(name = "fecha_final_proyecto")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_anticipado")
    private int valorAnticipado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total_proyecto")
    private int valorTotalProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminar")
    private boolean eliminar;
    @JoinColumn(name = "id_cotizacion", referencedColumnName = "id_cotizacion")
    @ManyToOne(optional = false)
    private Cotizacion idCotizacion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<EmpleadoHasProyecto> empleadoHasProyectoCollection;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String codigoProyecto, int valorAnticipado, int valorTotalProyecto, boolean eliminar) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.codigoProyecto = codigoProyecto;
        this.valorAnticipado = valorAnticipado;
        this.valorTotalProyecto = valorTotalProyecto;
        this.eliminar = eliminar;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public Date getFechaInicioProyecto() {
        return fechaInicioProyecto;
    }

    public void setFechaInicioProyecto(Date fechaInicioProyecto) {
        this.fechaInicioProyecto = fechaInicioProyecto;
    }

    public Date getFechaFinalProyecto() {
        return fechaFinalProyecto;
    }

    public void setFechaFinalProyecto(Date fechaFinalProyecto) {
        this.fechaFinalProyecto = fechaFinalProyecto;
    }

    public int getValorAnticipado() {
        return valorAnticipado;
    }

    public void setValorAnticipado(int valorAnticipado) {
        this.valorAnticipado = valorAnticipado;
    }

    public int getValorTotalProyecto() {
        return valorTotalProyecto;
    }

    public void setValorTotalProyecto(int valorTotalProyecto) {
        this.valorTotalProyecto = valorTotalProyecto;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<EmpleadoHasProyecto> getEmpleadoHasProyectoCollection() {
        return empleadoHasProyectoCollection;
    }

    public void setEmpleadoHasProyectoCollection(Collection<EmpleadoHasProyecto> empleadoHasProyectoCollection) {
        this.empleadoHasProyectoCollection = empleadoHasProyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
