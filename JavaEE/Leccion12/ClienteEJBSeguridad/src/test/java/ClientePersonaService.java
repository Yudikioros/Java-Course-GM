import com.sun.enterprise.security.ee.authentication.ProgrammaticLogin;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");

        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin login = new ProgrammaticLogin();
        login.login("admin", "admin".toCharArray());

        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup(
                    "java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.service.PersonaServiceRemote");

            List<Persona> personas = personaService.getPersonas();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\nFin de la llamada al EJB desde el cliente");

        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }


    }
}
