package mx.com.gm.sga.cliente.asociaciones;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

import java.util.List;

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();

        //Cerramos la conexion
        em.close();

        //Imprimir los objetos de tipo persona
        for (Persona persona : personas) {
            log.debug("Persona: " + persona);
            //Recuperamos los usuarios de cada persona
            for (Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario: " + usuario);
            }
        }

    }
}
