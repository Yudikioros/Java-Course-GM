package mx.com.gm.servicio;

import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

//    @Autowired
    private IPersonaDao personaDao;

    public PersonaServiceImpl(IPersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminarPersona(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
