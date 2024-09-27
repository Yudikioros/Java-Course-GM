package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;


@Named
@RequestScoped
public class Candidato {
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;

    Logger log = LogManager.getRootLogger();

    public Candidato() {
        log.info("Candidato creado");
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

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando salarioDeseado: " + this.salarioDeseado);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
