package mx.com.gm.sga.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import mx.com.gm.sga.domain.Persona;

import java.util.List;

@WebService
public interface PersonaServiceWS {
    @WebMethod
    public List<Persona> getPersonas();
}
