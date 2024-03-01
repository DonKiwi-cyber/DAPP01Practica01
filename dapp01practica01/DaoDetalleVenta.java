/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author francisco
 */
public class DaoDetalleVenta implements IDAOgeneral<Detalleventa> {
    SessionFactory sf=   HibernateUtil.getSessionFactory();
    @Override
    public boolean Save(Detalleventa detalle) {
             Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(detalle);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Edit(Detalleventa detalle) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(detalle);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Delete(int id) {
              Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Detalleventa detalle = session.get(Detalleventa.class, id);
        session.delete(detalle);
        transaction.commit();
        return true;
    }

    @Override
    public List<Detalleventa> Findbyid(int id) {
        Session session = sf.getCurrentSession();
    Transaction transaction = null;
    List<Detalleventa> resultList = null;

    try {
        transaction = session.beginTransaction();

        // Utilizamos una consulta HQL para buscar objetos por su identificador
        String hql = "FROM PojoEmpleado WHERE id = :id";
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
    public List<Detalleventa> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
