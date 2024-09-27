package mx.com.gm.servicio;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

import java.util.List;

public class ServicioPersonas {
    private PersonaDAO personaDAO = new PersonaDAO();

    public ServicioPersonas() {
        personaDAO = new PersonaDAO();
    }

    public List<Persona> listarPersonas() {
        return this.personaDAO.listar();
    }




}
