package mx.com.gm.sga.cliente.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

import java.util.Iterator;
import java.util.List;

public class PruebaJPQL {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query query = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iterator = null;
        Object[] tuple = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Paso 1. Consultar todos los objetos de tipo Persona
        log.debug("\n. Consulta de todas las personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);

        //2. Consulta de la persona con id = 1
        log.debug("\n2. Consulta de la persona con id = 1");
        jpql = "select p from Persona p where p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
//        log.debug(persona);

        //3. Consulta de la persona por nombre
        log.debug("\n3. Consulta de la persona con nombre = Karla");
        jpql = "select p from Persona p where p.nombre = 'Karla'";
        personas = em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);

        //4. Consulta de datos individuales, se crea un arreglo(tupla) de tipo object de 3 columnas
        log.debug("\n4. Consulta de datos individuales, se crea un arreglo(tupla) de tipo object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido , p.email as Email from Persona p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while (iterator.hasNext()) {
            tuple = (Object[]) iterator.next();
            String nombre = (String) tuple[0];
            String apellido = (String) tuple[1];
            String email = (String) tuple[2];
//            log.debug("Nombre: " + nombre + ", apellido: " + apellido + ", email: " + email);
        }

        //5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo object con 2 columnas
        log.debug("\n5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo object con 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while (iterator.hasNext()) {
            tuple = (Object[]) iterator.next();
            Persona p = (Persona) tuple[0];
            int idPersona = (int) tuple[1];
//            log.debug("Objeto Persona: " + persona);
//            log.debug("Id Persona: " + idPersona);
        }

        //6. Consulta de todas las personas
        log.debug("\n6. Consulta de todas las personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas  = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //7. Regresa el valor minimo y maximo del idPersona (scaler result)
        log.debug("\n7. Regresa el valor minimo y maximo del idPersona (scaler result)");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while (iterator.hasNext()) {
            tuple = (Object[]) iterator.next();
            Integer idMin = (Integer) tuple[0];
            Integer idMax = (Integer) tuple[1];
            Long contador = (Long) tuple[2];
            log.debug("idMin: " + idMin + " idMax: " + idMax +" contador: " + contador);
        }

        //8. Cuenta los nombres de las personas que son distintos
        log.debug("\n8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("Numero de personas con nombres distintos: " + contador);


        //9. Concatena y convierte a mayusculas el nombre y apellido
        log.debug("\n9. Concatena y convierte a mayusculas el nombre y apellido");
        jpql = "select concat(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombre : nombres) {
            log.debug("Nombre: " + nombre);
        }

        //10.  Obtiene el objeto persona con id igual al parametro proporcionado
        log.debug("\n10. Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 2;
        jpql = "select p from Persona p where p.idPersona = :id";
        query = em.createQuery(jpql);
        query.setParameter("id", idPersona);
        persona = (Persona) query.getSingleResult();
        log.debug(persona);

        //11. Obtiene las personas que contengan  una letra a en el nombre, sin importar si es mayuscula o minuscula
        log.debug("\n11. Obtiene las personas que contengan  una letra a en el nombre, sin importar si es mayuscula o minuscula");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro) ";
        String parametro = "%a%";// Es el caracter que utilizamos para el like
        query = em.createQuery(jpql);
        query.setParameter("parametro", parametro);
        personas  = query.getResultList();
        mostrarPersonas(personas);

        //12. Uso de between
        log.debug("\n12. Uso de between ");
        jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //13. Uso del ordenamiento
        log.debug("\n13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.idPersona > 1 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //14. Uso de subquery
        log.debug("\n14. Uso de subquery");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //15. Uso de join con lazy loading
        log.debug("\n15. Uso de join con lazy loading");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);

        //16. Uso de left join con eager loading
        log.debug("\n16. Uso de left join con eager loading");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);






    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            log.debug(usuario);
        }
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
}
