import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;

import java.util.List;

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        System.out.println("Ejecutando servicio PersonaServiceWS");
        List<Persona> personas = personaService.getPersonas();
        for (Persona persona : personas) {
            System.out.println("Persona Id: " + persona.getIdPersona() + " Nombre: " + persona.getNombre() + " Apellido: " + persona.getApellido()+
                    "Email: " + persona.getEmail() + " Telefono: " + persona.getTelefono());
        }
        System.out.println("Fin de Servicio PersonaServiceWS");
    }
}
