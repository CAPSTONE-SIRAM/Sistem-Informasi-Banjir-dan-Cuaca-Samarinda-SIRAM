/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Util.HibernateUtil;
import Model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
/**
 *
 * @author User
 */



public class UsersControl {

    // ================= Registrasi User =================
    public boolean registerUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);  // Menyimpan user baru
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Users loginUser(String usernameOrEmail, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Users WHERE (username = :ue OR email = :ue) AND password = :pw";
            Query<Users> query = session.createQuery(hql, Users.class);
            query.setParameter("ue", usernameOrEmail);
            query.setParameter("pw", password);

            return query.uniqueResult(); // null jika gagal login
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Users> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Users", Users.class).list();
        }
    }

    // ================= Update User =================
    public boolean updateUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // ================= Hapus User =================
    public boolean deleteUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}