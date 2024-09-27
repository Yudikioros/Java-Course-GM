package mx.com.gm.dao;

import jakarta.persistence.Query;
import mx.com.gm.domain.Curso;

import java.util.List;

public class ContactoDAO extends GenericDAO{
    public List<Curso> listar() {
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }

    public void insertar(Curso c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(c);
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

    public void actualizar(Curso c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(c);
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

    public void eliminar(Curso c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(c));
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

    public Object buscarPorId(Curso c) {
        em = getEntityManager();
        return em.find(Curso.class, c.getIdCurso());
    }
}
