import jakarta.persistence.*;
import mx.com.gm.domain.Persona;

import java.util.List;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for (Persona persona : personas) {
            System.out.println(persona);
        }


    }
}
