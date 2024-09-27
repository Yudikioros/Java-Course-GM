package mx.com.gm.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Domicilio implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;

    private String calle;

    @Column(name = "no_calle")
    private String noCalle;

    private String pais;

    public Domicilio() {}

    public Domicilio(Integer idDomicilio){
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Domicilio{");
        sb.append("idDomicilio=").append(idDomicilio);
        sb.append(", calle='").append(calle).append('\'');
        sb.append(", noCalle='").append(noCalle).append('\'');
        sb.append(", pais='").append(pais).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(getIdDomicilio(), domicilio.getIdDomicilio());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDomicilio());
    }
}
