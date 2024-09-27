package mx.com.gm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Persona.listarPersonas", query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})
public class Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    private String nombre;

    public Persona() {

    }
    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public Persona(Integer idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
