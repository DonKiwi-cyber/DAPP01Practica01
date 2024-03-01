package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ian
 */

public class DaoDetalleVenta implements IDAOgeneral<DetalleVenta> {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    @Override
    public boolean Save(DetalleVenta detVenta) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(detVenta);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Edit(DetalleVenta detVenta) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(detVenta);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Delete(long id) {
           Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        DetalleVenta detVenta = session.get(Venta.class, id);
        session.delete(detVenta);
        transaction.commit();
        return true;
    }

    @Override
    public List<Venta> Findbyid(long id) {
        Session session = sf.getCurrentSession();
        Transaction transaction = null;
        List<DetalleVenta> resultList = null;

    try {
        transaction = session.beginTransaction();

        // Utilizamos una consulta HQL para buscar objetos por su identificador
        String hql = "FROM DetalleVenta WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        
        // Ejecutamos la consulta y obtenemos la lista de resultados
        resultList = query.getResultList();

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }

    return resultList;
    }

    @Override
    public List<Venta> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}