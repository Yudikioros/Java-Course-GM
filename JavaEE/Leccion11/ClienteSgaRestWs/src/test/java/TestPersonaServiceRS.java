import domain.Persona;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;

import java.util.List;

public class TestPersonaServiceRS {
    //Variables a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client client;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    public static void main(String[] args) {
        client = ClientBuilder.newClient();

        //Leer una persona (metodo get)
        webTarget = client.target(URL_BASE + "/personas");
        //Proporcionamos un id persona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);

        //Leer todas las personas (metodo get con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML)
                .get(Response.class)
                .readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nLista de personas");
        imprimirPersonas(personas);

        //Agregar una persona
        Persona newPersona = new Persona();
        newPersona.setNombre("Carlos");
        newPersona.setApellido("Miranda");
        newPersona.setEmail("cmiranda3@gmail.com");
        newPersona.setTelefono("123456789");

        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(newPersona, MediaType.APPLICATION_XML));
        System.out.println();
        System.out.println(response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y eliminarla
        Persona recoveredPersona = response.readEntity(Persona.class);
        System.out.println("Persona recuperada: " + recoveredPersona);

        //Modificar la persona recien agregada
        Persona personaToUpdate = recoveredPersona;
        personaToUpdate.setApellido("Ramirez");
        String pathId = "/" + personaToUpdate.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaToUpdate, MediaType.APPLICATION_XML));
        System.out.println();
        System.out.println(response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class ));

        //Eliminar a la persona recien agregada
        Persona personaToDelete = recoveredPersona;
        String pathDelete = "/" + personaToDelete.getIdPersona();
        invocationBuilder = webTarget.path(pathDelete).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println();
        System.out.println(response.getStatus());
        System.out.println("Persona eliminada: " + personaToDelete);

    }

    private static void imprimirPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

}
