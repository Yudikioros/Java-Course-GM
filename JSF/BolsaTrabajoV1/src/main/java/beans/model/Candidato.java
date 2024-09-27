package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Named
@RequestScoped
public class Candidato {
    private String nombre;
    private String apellido;
    private String salarioDeseado;
    Logger log = LogManager.getRootLogger();

    public Candidato() {
        log.info("Candidato creado");
        this.setNombre("Introduce tu nombre");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando nombre: " + this.nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando apellido: " + this.apellido);
    }

    public String getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(String salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando salarioDeseado: " + this.salarioDeseado);
    }
}
