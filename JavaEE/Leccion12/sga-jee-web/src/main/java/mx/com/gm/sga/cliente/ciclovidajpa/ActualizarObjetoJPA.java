package mx.com.gm.sga.cliente.ciclovidajpa;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion

        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        //El id proporcionado debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 1);

        //Paso 3. Termina la transaccion 1
        tx.commit();

        //Objeto en estado de detached
        log.debug("Objeto recuperado: " + persona1);

        //Paso 4. setValue (nuevoValor)
        persona1.setApellido("Juarez");

        //Paso 5. Inicia la transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Paso 6. Modificamos el objeto
        em.merge(persona1);
//        em.flush();

        //Paso 7. Termina transaccion 2
        tx2.commit();

        //Objeto en estado de detached ya modificado
        log.debug("Objeto recuperado: " + persona1);


        //Cerramos el entity manager
        em.close();

    }
}
