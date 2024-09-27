package mx.com.gm.dao;

import jakarta.persistence.Query;
import mx.com.gm.domain.Asignacion;

import java.util.List;

public class AsignacionDAO extends GenericDAO{
    public List<Asignacion> listar() {
        String consulta = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }

    public void insertar(Asignacion a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(a);
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

    public void actualizar(Asignacion a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(a);
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

    public void eliminar(Asignacion a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(a));
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

    public Asignacion buscarPorId(Asignacion a) {
        em = getEntityManager();
        return em.find(Asignacion.class, a.getIdAsignacion());
    }
}
