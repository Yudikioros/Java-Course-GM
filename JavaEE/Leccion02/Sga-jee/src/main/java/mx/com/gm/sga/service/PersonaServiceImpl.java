package mx.com.gm.sga.service;

import jakarta.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Juan", "Perez", "jperez@gmail.com", "5522331144"));
        personas.add(new Persona(2, "Marta", "Suarez", "msuarez@gmail.com", "5522881144"));
        return personas;
    }

    @Override
    public Persona getPersona(int id) {
        return null;
    }

    @Override
    public Persona getPersona(String email) {
        return null;
    }

    @Override
    public void addPersona(Persona persona) {

    }

    @Override
    public void updatePersona(Persona persona) {

    }

    @Override
    public void deletePersona(Persona persona) {

    }
}
