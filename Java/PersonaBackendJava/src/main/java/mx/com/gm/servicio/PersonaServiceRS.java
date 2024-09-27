package mx.com.gm.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.com.gm.data.PersonaDao;
import mx.com.gm.domain.Persona;

import java.util.List;

@Stateless
@Path("/personas")
public class PersonaServiceRS {
    @Inject
     private PersonaDao personaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas(){
        var personas = personaDao.listarPersonas();
        System.out.println("Personas: " + personas);
        return personas;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")// Referencia a /personas/{id}
    public Persona buscarPersona(@PathParam("id") int id){
        var persona = personaDao.buscarPersona(new Persona(id));
        System.out.println("Persona: " + persona);
        return persona;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona){
        personaDao.insertarPersona(persona);
        System.out.println("Persona: " + persona);
        return persona;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response actualizarPersona(@PathParam("id") int id, Persona persona){
        var Persona = personaDao.buscarPersona(new Persona(id));
        if(persona != null){
            personaDao.modificarPersona(persona);
            System.out.println("Persona: " + persona);
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(persona).build();
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id){
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("Persona: " + id);
        return Response.ok().build();
    }

}
