/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Cuaca;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author User
 */
public class CuacaDAOImpl implements CuacaDAO {

    @Override
    public void insert(Cuaca cuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cuaca);
        t.commit();
        session.close();
    }

    @Override
    public void update(Cuaca cuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(cuaca);
        t.commit();
        session.close();
    }

    @Override
    public void delete(int idCuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Cuaca cuaca = session.get(Cuaca.class, idCuaca);
        if (cuaca != null) {
            session.delete(cuaca);
        }
        t.commit();
        session.close();
    }

    @Override
    public Cuaca getById(int idCuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cuaca cuaca = session.get(Cuaca.class, idCuaca);
        session.close();
        return cuaca;
    }

    @Override
    public List<Cuaca> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Cuaca> result = new java.util.ArrayList<>();

        result.addAll(session.createQuery("FROM CuacaPanas", Cuaca.class).list());
        result.addAll(session.createQuery("FROM CuacaHujan", Cuaca.class).list());

        session.close();
    return result;
    }
}
