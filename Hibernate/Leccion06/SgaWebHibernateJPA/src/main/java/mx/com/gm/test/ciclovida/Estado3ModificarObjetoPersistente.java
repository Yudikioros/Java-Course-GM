package mx.com.gm.test.ciclovida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Recuperamos un objeto de la base de datos

        //Definimos variable
        Contacto contacto = null;

        //Recuperamos el objeto
        //1.Detached
        contacto = em.find(Contacto.class, 3);

        //Modificamos
        contacto.setEmail("clara@mail.com");

        em.getTransaction().begin();

        //2.persistente
//        em.persist(contacto);
        em.merge(contacto);

        //3.Detached
        em.getTransaction().commit();

        //Detached
        System.out.println("Contacto: " + contacto);

    }
}
