package mx.com.gm.sga.service;

import jakarta.ejb.Remote;
import mx.com.gm.sga.domain.Persona;

import java.util.List;

@Remote
public interface PersonaServiceRemote {
    public List<Persona> getPersonas();
    public Persona getPersona(int id);
    public Persona getPersona(String email);
    public void addPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deletePersona(Persona persona);
}
