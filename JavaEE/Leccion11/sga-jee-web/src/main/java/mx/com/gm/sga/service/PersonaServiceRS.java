package mx.com.gm.sga.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;

import java.util.List;

@Path("/personas")
@Stateless
public class PersonaServiceRS {
    @Inject
    private PersonaService personaService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//Hace referencia a /personas/{id}
    public Persona getPersona(@PathParam("id") int id) {
        return personaService.getPersonaById(new Persona(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addPersona(Persona persona) {
        try {
            personaService.addPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updatePersona(Persona newPersona, @PathParam("id") int id) {
        try {
            Persona persona = personaService.getPersonaById(new Persona(id));
            if (persona != null) {
                personaService.updatePersona(newPersona);
                return Response.ok().entity(newPersona).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePersona(@PathParam("id") int id) {
        try {
            personaService.deletePersona(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.NOT_FOUND).build();
        }
    }

}
