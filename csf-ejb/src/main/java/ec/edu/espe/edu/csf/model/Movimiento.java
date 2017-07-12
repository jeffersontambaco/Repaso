/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.edu.csf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jeffe
 */
@Entity
@Table(name = "movimiento")
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_COD", nullable = false)
    private Integer movCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MOV_TIPO", nullable = false, length = 3)
    private String movTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO", nullable = false, precision = 15, scale = 2)
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_SALDO", nullable = false, precision = 15, scale = 2)
    private BigDecimal movSaldo;
    @JoinColumn(name = "CUE_CODIGO", referencedColumnName = "CUE_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Cuenta cueCodigo;

    public Movimiento() {
    }

    public Movimiento(Integer movCod) {
        this.movCod = movCod;
    }

    public Movimiento(Integer movCod, String movTipo, Date fecha, BigDecimal monto, BigDecimal movSaldo) {
        this.movCod = movCod;
        this.movTipo = movTipo;
        this.fecha = fecha;
        this.monto = monto;
        this.movSaldo = movSaldo;
    }

    public Integer getMovCod() {
        return movCod;
    }

    public void setMovCod(Integer movCod) {
        this.movCod = movCod;
    }

    public String getMovTipo() {
        return movTipo;
    }

    public void setMovTipo(String movTipo) {
        this.movTipo = movTipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMovSaldo() {
        return movSaldo;
    }

    public void setMovSaldo(BigDecimal movSaldo) {
        this.movSaldo = movSaldo;
    }

    public Cuenta getCueCodigo() {
        return cueCodigo;
    }

    public void setCueCodigo(Cuenta cueCodigo) {
        this.cueCodigo = cueCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movCod != null ? movCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.movCod == null && other.movCod != null) || (this.movCod != null && !this.movCod.equals(other.movCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.edu.csf.model.Movimiento[ movCod=" + movCod + " ]";
    }
    
}
