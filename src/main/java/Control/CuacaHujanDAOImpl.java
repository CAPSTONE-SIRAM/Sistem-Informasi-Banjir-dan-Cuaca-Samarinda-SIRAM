/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.CuacaHujan;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author User
 */
public class CuacaHujanDAOImpl implements CuacaHujanDAO {

    @Override
    public void insert(CuacaHujan ch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(ch);
        t.commit();
        session.close();
    }

    @Override
    public void update(CuacaHujan ch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(ch);
        t.commit();
        session.close();
    }

    @Override
    public void delete(int idCuaca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        CuacaHujan cuaca = session.get(CuacaHujan.class, idCuaca);
        if (cuaca != null) session.delete(cuaca);
        t.commit();
        session.close();
    }

    @Override
    public List<CuacaHujan> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CuacaHujan> list = session.createQuery("FROM CuacaHujan", CuacaHujan.class).list();
        session.close();
        return list;
    }
}
