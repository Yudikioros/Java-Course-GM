package mx.com.gm.servicio;

import mx.com.gm.domain.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> listarPersonas();
    public void guardarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
