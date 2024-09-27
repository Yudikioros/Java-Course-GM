package mx.com.gm.sga.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.gm.sga.data.PersonaDao;
import mx.com.gm.sga.domain.Persona;

import java.util.List;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

    @Inject
    private PersonaDao personaDao;

    @Override
    public List<Persona> getPersonas() {
        return personaDao.getPersonas();
    }

    @Override
    public Persona getPersonaById(Persona persona) {
        return personaDao.getPersonaById(persona);
    }

    @Override
    public Persona getPersonaByEmail(Persona persona) {
        return personaDao.getPersonaByEmail(persona);
    }

    @Override
    public void addPersona(Persona persona) {
        personaDao.add(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        personaDao.update(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        personaDao.delete(persona);
    }
}
