package mx.com.gm.sga.data;

import mx.com.gm.sga.domain.Persona;

import java.util.List;

public interface PersonaDao {
    public List<Persona> getPersonas();
    public Persona getPersonaById(Persona persona);
    public Persona getPersonaByEmail(Persona persona);
    public void add(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}
