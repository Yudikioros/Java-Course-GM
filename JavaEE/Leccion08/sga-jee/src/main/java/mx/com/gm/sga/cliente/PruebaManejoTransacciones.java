package mx.com.gm.sga.cliente;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        try {
            Context jndiContext = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndiContext.lookup(
                    "java:global/sga-jee-web-1.0-SNAPSHOT/PersonaServiceImpl!mx.com.gm.sga.service.PersonaServiceRemote");
            log.debug("Iniciando prueba Manejo Transacciones PersonaService");

            //Buscar un objeto persona
            Persona persona1 = personaService.getPersonaById(new Persona(1));

            log.debug("Persona encontrada: " + persona1);

            //Cambiar el apellido de la persona
            persona1.setApellido("Perez");

            personaService.updatePersona(persona1);
            log.debug("Objeto modificado: " + persona1);
            log.debug("Fin de prueba Manejo Transacciones");



        } catch (NamingException e) {
            log.debug(e.getMessage());
        }
    }
}
