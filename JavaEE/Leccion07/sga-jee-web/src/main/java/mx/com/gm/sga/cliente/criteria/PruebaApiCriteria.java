package mx.com.gm.sga.cliente.criteria;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.List;

public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //Query utilizando el API de Criteria
        //1. Consulta de todas las personas

        //Paso 1. El objeto EntityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();

        //Paso 2.  Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);

        //Paso 3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);

        //Paso 4. Seleccionalmos lo necesario del from
        criteriaQuery.select(fromPersona);

        //Paso 5. Creamos el tipo de query typesafe
        query = em.createQuery(criteriaQuery);

        //Paso 6. Ejecutamos la consulta
        personas  = query.getResultList();

        mostrarPersonas(personas);

        //2-a. Consulta de la persona con id = 1
        log.debug("\n2-a. Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);


        //2-b. Consula de la persona con id = 1
        log.debug("\n2-b. Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        //La clase Predicate permite agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();

        //Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 1;
        ParameterExpression<Integer>  parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));

        //Se agregan los criteros
        if (criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() == 1) {
            criteriaQuery.where(criterios.get(0));
        }else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }

        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);

        //Ejecutamos el query
        persona = query.getSingleResult();
        log.debug(persona);


    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas){
            log.debug(p);
        }
    }
}
