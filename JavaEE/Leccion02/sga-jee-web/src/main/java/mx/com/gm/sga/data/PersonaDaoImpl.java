package mx.com.gm.sga.data;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;

import java.util.List;

@Stateless
public class PersonaDaoImpl implements PersonaDao{
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> getPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona getPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona getPersonaByEmail(Persona persona) {
        Query query = em.createQuery("SELECT p FROM Persona p  where p.email = :email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void add(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void update(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void delete(Persona persona) {
        em.remove(em.merge(persona));
    }
}
