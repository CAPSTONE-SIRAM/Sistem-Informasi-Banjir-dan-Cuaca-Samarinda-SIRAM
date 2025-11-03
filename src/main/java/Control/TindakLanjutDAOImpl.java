/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.TindakLanjut;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
/**
 *
 * @author User
 */



public class TindakLanjutDAOImpl implements TindakLanjutDAO {

    private EntityManagerFactory emf;

    public TindakLanjutDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(TindakLanjut tindak) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tindak);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public TindakLanjut findById(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TindakLanjut.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<TindakLanjut> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM TindakLanjut t", TindakLanjut.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(TindakLanjut tindak) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tindak);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            TindakLanjut tindak = em.find(TindakLanjut.class, id);
            if (tindak != null) em.remove(tindak);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null) emf.close();
    }
}
