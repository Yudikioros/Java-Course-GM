package mx.com.gm.dao;

import jakarta.persistence.Query;
import mx.com.gm.domain.Domicilio;

import java.util.List;
import java.util.Objects;

public class DomicilioDAO extends GenericDAO {
    public List<Domicilio> listar() {
        String consulta = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }

    public void insertar(Domicilio d) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void actualizar(Domicilio d) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminar(Domicilio d) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(d));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Object buscarPorId(Domicilio d) {
        em = getEntityManager();
        return em.find(Domicilio.class, d.getIdDomicilio());
    }

}
