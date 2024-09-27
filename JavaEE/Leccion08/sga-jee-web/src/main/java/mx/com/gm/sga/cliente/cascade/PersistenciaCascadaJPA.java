package mx.com.gm.sga.cliente.cascade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 1. Crea de nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Hugo","Hernandez","hhernandez@gmail.com","1234567822");

        //Paso 2. Crear objeto usuario (dependiente de objeto persona)
        Usuario usuario1 = new Usuario("hhernandez","123", persona1);

        //Paso 3. Persistimos SOLO el objeto usuario
        em.persist(usuario1);

        //Paso 4. commit de la transaccion
        tx.commit();

        //Objetos en estado de detached
        log.debug("Persona: " + persona1);
        log.debug("Usuario: " + usuario1);

        em.close();

    }
}
