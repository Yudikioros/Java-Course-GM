package mx.com.gm.test.ciclovida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Recuperamos un objeto de la base de datos

        //Definimos variable
        Contacto contacto = null;

        em.getTransaction().begin();
        //Recuperamos el objeto
        contacto = em.find(Contacto.class, 3);

        em.getTransaction().commit();

        //Detached
        System.out.println("Contacto: " + contacto);

    }
}
