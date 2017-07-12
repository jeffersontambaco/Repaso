/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.edu.csf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jeffe
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CUE_CODIGO", nullable = false, length = 8)
    private String cueCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CUE_TIPO", nullable = false, length = 3)
    private String cueTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cueCodigo")
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA", nullable = false)
    @ManyToOne(optional = false)
    private Cliente cedula;

    public Cuenta() {
    }

    public Cuenta(String cueCodigo) {
        this.cueCodigo = cueCodigo;
    }

    public Cuenta(String cueCodigo, BigDecimal saldo, String estado, String cueTipo) {
        this.cueCodigo = cueCodigo;
        this.saldo = saldo;
        this.estado = estado;
        this.cueTipo = cueTipo;
    }

    public String getCueCodigo() {
        return cueCodigo;
    }

    public void setCueCodigo(String cueCodigo) {
        this.cueCodigo = cueCodigo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCueTipo() {
        return cueTipo;
    }

    public void setCueTipo(String cueTipo) {
        this.cueTipo = cueTipo;
    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cueCodigo != null ? cueCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cueCodigo == null && other.cueCodigo != null) || (this.cueCodigo != null && !this.cueCodigo.equals(other.cueCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.edu.csf.model.Cuenta[ cueCodigo=" + cueCodigo + " ]";
    }
    
}
