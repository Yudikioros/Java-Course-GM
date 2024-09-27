package mx.com.gm.dao;

import jakarta.persistence.Query;
import mx.com.gm.domain.Alumno;

import java.util.List;

public class AlumnoDAO extends GenericDAO{
    public List<Alumno> listar() {
        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }

    public void insertar(Alumno a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(a);
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

    public void actualizar(Alumno a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(a);
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

    public void eliminar(Alumno a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(a));
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

    public Object buscarPorId(Alumno a) {
        em = getEntityManager();
        return em.find(Alumno.class, a.getIdAlumno());
    }
}
