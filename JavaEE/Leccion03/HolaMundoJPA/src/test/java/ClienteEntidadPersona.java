import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        //Inicia la transaccion
        tx.begin();
        //No es necesario especificar el ID
        Persona persona = new Persona("Maria", "Gutierrez","mgutierrez@gmail.com","1122337700");
        log.debug("Objeto a persistir: " + persona);
        //Persistimos el objeto
        em.persist(persona);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido: " + persona);
        em.close();

    }

}
