import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;

import javax.xml.ws.BindingProvider;
import java.util.List;

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();

        ((BindingProvider) personaService).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider) personaService).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

        System.out.println("Ejecutando servicio PersonaServiceWS");
        List<Persona> personas = personaService.getPersonas();
        for (Persona persona : personas) {
            System.out.println("Persona Id: " + persona.getIdPersona() + " Nombre: " + persona.getNombre() + " Apellido: " + persona.getApellido()+
                    "Email: " + persona.getEmail() + " Telefono: " + persona.getTelefono());
        }
        System.out.println("Fin de Servicio PersonaServiceWS");
    }
}
