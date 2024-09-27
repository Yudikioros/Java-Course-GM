package mx.com.gm.data;

import mx.com.gm.domain.Persona;

import java.util.List;

public interface PersonaDao {
    public List<Persona> listarPersonas();
    public Persona buscarPersona(Persona persona);
    public void insertarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
