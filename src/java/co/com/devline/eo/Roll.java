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
@Table(name = "roll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roll.findAll", query = "SELECT r FROM Roll r"),
    @NamedQuery(name = "Roll.findByTipoRoll", query = "SELECT r FROM Roll r WHERE r.tipoRoll = :tipoRoll")})
public class Roll implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_roll")
    private String tipoRoll;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRoll")
    private Collection<Usuario> usuarioCollection;

    public Roll() {
    }

    public Roll(String tipoRoll) {
        this.tipoRoll = tipoRoll;
    }

    public String getTipoRoll() {
        return tipoRoll;
    }

    public void setTipoRoll(String tipoRoll) {
        this.tipoRoll = tipoRoll;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRoll != null ? tipoRoll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roll)) {
            return false;
        }
        Roll other = (Roll) object;
        if ((this.tipoRoll == null && other.tipoRoll != null) || (this.tipoRoll != null && !this.tipoRoll.equals(other.tipoRoll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.devline.eo.Roll[ tipoRoll=" + tipoRoll + " ]";
    }
    
}
