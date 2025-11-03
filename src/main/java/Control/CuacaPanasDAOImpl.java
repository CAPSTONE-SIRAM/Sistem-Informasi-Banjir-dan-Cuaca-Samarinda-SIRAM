/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.CuacaPanas;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class CuacaPanasDAOImpl implements CuacaPanasDAO {

    @Override
    public void insert(CuacaPanas cp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cp);
        t.commit();
        session.close();
    }

    @Override
    public void update(CuacaPanas cp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(cp);
        t.commit();
        session.close();
    }

    @Override
    public void delete(int idCuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        CuacaPanas cuaca = session.get(CuacaPanas.class, idCuaca);
        if (cuaca != null) session.delete(cuaca);
        t.commit();
        session.close();
    }

    @Override
    public List<CuacaPanas> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CuacaPanas> list = session.createQuery("FROM CuacaPanas", CuacaPanas.class).list();
        session.close();
        return list;
    }
}
