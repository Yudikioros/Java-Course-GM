package mx.com.gm.data;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.gm.domain.Persona;

import java.util.List;

@Stateless
public class PersonaDaoImpl implements PersonaDao {
    @PersistenceContext(unitName = "PersonaPU")
    private EntityManager em;


    @Override
    public Persona buscarPersona(Persona persona) {
        return em.find(Persona.class,persona.getIdPersona());
    }

    @Override
    public List<Persona> listarPersonas() {
        return em.createNamedQuery("Persona.listarPersonas").getResultList();
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        em.flush();
    }

    @Override
    public void modificarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        em.remove(em.merge(persona));
    }
}
