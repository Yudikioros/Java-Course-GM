package mx.com.gm.sga.service;

import mx.com.gm.sga.domain.Persona;

import java.util.List;

public interface PersonaServiceRemote {
    public List<Persona> getPersonas();

    public Persona getPersonaById(Persona persona);

    public Persona getPersonaByEmail(Persona persona);

    public void addPersona(Persona persona);

    public void updatePersona(Persona persona);

    public void deletePersona(Persona persona);
}
