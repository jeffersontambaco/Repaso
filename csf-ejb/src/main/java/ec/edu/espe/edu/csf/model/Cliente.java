package ec.edu.espe.edu.csf.model;

import java.io.Serializable;
import java.util.List;
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

@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "CEDULA", nullable = false, length = 13)
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLI_NOMBRE", nullable = false, length = 50)
    private String cliNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula")
    private List<Cuenta> cuentaList;

    public Cliente() {
    }

    public Cliente(String cedula) {
        this.cedula = cedula;
        //envia cedula
        //cliente
        //cliente

        //otra prueba

        //nuevo cliente

    }

    public Cliente(String cedula, String cliNombre) {
        this.cedula = cedula;
        this.cliNombre = cliNombre;

        //cleintenuevo
        //h
    }

    public String getCedula() {
        return cedula;
        //otra mas 
        //nueva para
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;

        //comer
        //ultima prueba

        //pryue

    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.edu.csf.model.Cliente[ cedula=" + cedula + " ]";
    }

}
