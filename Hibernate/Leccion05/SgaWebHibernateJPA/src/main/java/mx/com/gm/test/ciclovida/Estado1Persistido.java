package mx.com.gm.test.ciclovida;

import jakarta.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //1. Estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara@gmail.com");
        contacto.setTelefono("1233214567");

        //2. Persistimos el objeto
        em.getTransaction().begin();//Iniciamos transaccion
        em.persist(contacto);
//        em.flush();// Sincronizamos los cambios pendientes
        em.getTransaction().commit();//Guardamos cambios de la transaccion

        //3. detached (separado)
        System.out.println("Contacto: " + contacto);

    }
}
