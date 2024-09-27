package mx.com.gm.test.ciclovida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Recuperamos un objeto de la base de datos

        //Definimos variable
        Contacto contacto = null;

        //Recuperamos el objeto
        //1.Detached
        contacto = em.find(Contacto.class, 3);

        em.getTransaction().begin();

        //2.Remove
        em.remove(em.merge(contacto));

        //3.Detached
        em.getTransaction().commit();

        //3. Transitivo (Eliminado por garbage collector)
        System.out.println("Contacto: " + contacto);

    }
}
