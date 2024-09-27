package mx.com.gm.dao;

import jakarta.persistence.Query;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Contacto;

import java.util.List;

public class ContactoDAO extends GenericDAO{
    public List<Contacto> listar() {
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }

    public void insertar(Contacto c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void actualizar(Contacto c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void eliminar(Contacto c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(c));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public Contacto buscarPorId(Contacto c) {
        em = getEntityManager();
        return em.find(Contacto.class, c.getIdContacto());
    }
}
