package mx.com.gm.sga.web;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import java.util.List;

@Named("personaBean")
@RequestScoped
public class PersonaBean {
    private Logger log = LogManager.getRootLogger();

    @Inject
    private PersonaService personaService;

    private Persona personaSeleccionada;

    private List<Persona> personas;

    public PersonaBean() {
        log.debug("Iniciando personaBean");
    }

    @PostConstruct
    public void init() {
        //Iniciamos las variables
        personas = personaService.getPersonas();
        log.debug("Personas recuperadas: " + this.personas);
        personaSeleccionada = new Persona();
    }

    public void editListener(RowEditEvent event) {
        personaSeleccionada = (Persona) event.getObject();
        personaService.updatePersona(personaSeleccionada);
    }

    public void addPersona() {
        this.personaService.addPersona(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void removePersona() {
        this.personaService.deletePersona(personaSeleccionada);
        this.personas.remove(personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void restartPersonaSeleccionada() {
        this.personaSeleccionada = new Persona();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
}
