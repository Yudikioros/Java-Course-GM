package mx.com.gm.sga.cliente;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;

import javax.naming.*;
import java.util.List;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");

        try {
            Context jndiContext = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndiContext.lookup(
                    "java:global/Sga-jee/PersonaServiceImpl!mx.com.gm.sga.service.PersonaServiceRemote");
            List<Persona> personas = personaService.getPersonas();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\nFinalizando llamada al EJB desde el cliente");

        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }

    }
}
