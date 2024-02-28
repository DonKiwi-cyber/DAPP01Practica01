/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author francisco
 */
public class daoempleado implements IDAOgeneral<Object> {
    SessionFactory sf=   HibernateUtil.getSessionFactory();
    @Override
    public boolean Save(Object p) {
         Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
        return true;
      
    }

    @Override
    public boolean Edit(Object p) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Delete(int id) {
           Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PojoEmpleado empleado = session.get(PojoEmpleado.class, id);
        session.delete(empleado);
        transaction.commit();
        return true;
    }

        @Override
        public List<Object> Findbyid(int id) {
  Session session = sf.getCurrentSession();
    Transaction transaction = null;
    List<Object> resultList = null;

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
    public List<Object> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
