package mx.com.gm.sga.cliente.ciclovidajpa;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion

        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecutamos el SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);

        log.debug("Objeto encontrado: " + persona1);

        //Paso 3. setValue(nuevoValor)
        persona1.setEmail("jjuarez@gmail.com");

        //Paso 4. Termina la transaccion 1
        tx.commit();

        //Objeto en estado detached
        log.debug("Objeto modificado: " + persona1);

        //Cerramos el entity manager
        em.close();

    }
}
