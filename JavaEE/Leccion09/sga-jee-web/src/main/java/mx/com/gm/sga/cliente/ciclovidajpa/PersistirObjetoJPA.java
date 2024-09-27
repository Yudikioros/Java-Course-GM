package mx.com.gm.sga.cliente.ciclovidajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Inicia la transaccion

        //Paso 1. Creamos un nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro","Luna","pluna@gmail.com","1122546789");

        // Paso 2. Inicia la transaccion
        tx.begin();

        //Paso 3. Ejecuta SQL
        em.persist(persona1);

        log.debug("Objeto persistido - aun sin commit: " + persona1);

        //Paso 4. commit/rollback
        tx.commit();

        //Objeto en estado de detached
        log.debug("Objeto persistido - en estado detached: " + persona1);

        //Cerramos el entity manager
        em.close();

    }
}
