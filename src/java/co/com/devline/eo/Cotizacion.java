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
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByIdCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idCotizacion = :idCotizacion"),
    @NamedQuery(name = "Cotizacion.findByFechaCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.fechaCotizacion = :fechaCotizacion"),
    @NamedQuery(name = "Cotizacion.findByNotaInicio", query = "SELECT c FROM Cotizacion c WHERE c.notaInicio = :notaInicio"),
    @NamedQuery(name = "Cotizacion.findByIva", query = "SELECT c FROM Cotizacion c WHERE c.iva = :iva"),
    @NamedQuery(name = "Cotizacion.findByNotaFinal", query = "SELECT c FROM Cotizacion c WHERE c.notaFinal = :notaFinal"),
    @NamedQuery(name = "Cotizacion.findByEliminar", query = "SELECT c FROM Cotizacion c WHERE c.eliminar = :eliminar")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cotizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCotizacion;
    @Size(max = 500)
    @Column(name = "nota_inicio")
    private String notaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private float iva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nota_final")
    private String notaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminar")
    private boolean eliminar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotizacion")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotizacion")
    private Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cotizacion(Integer idCotizacion, Date fechaCotizacion, float iva, String notaFinal, boolean eliminar) {
        this.idCotizacion = idCotizacion;
        this.fechaCotizacion = fechaCotizacion;
        this.iva = iva;
        this.notaFinal = notaFinal;
        this.eliminar = eliminar;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public String getNotaInicio() {
        return notaInicio;
    }

    public void setNotaInicio(String notaInicio) {
        this.notaInicio = notaInicio;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @XmlTransient
    public Collection<CotizacionHasMaterial> getCotizacionHasMaterialCollection() {
        return cotizacionHasMaterialCollection;
    }

    public void setCotizacionHasMaterialCollection(Collection<CotizacionHasMaterial> cotizacionHasMaterialCollection) {
        this.cotizacionHasMaterialCollection = cotizacionHasMaterialCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fechaCotizacion + " " + idCliente.getNombre();
    }
    
}
