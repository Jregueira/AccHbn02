package com.arteysoft.hbn;

import java.lang.reflect.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UsuarioRepository<T> {
    private SessionFactory sessionFactory;

    public UsuarioRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Usuario obtener(String id) {
        Session session = sessionFactory.openSession();
        Usuario u = session.get(Usuario.class, id);
        session.close();
        return u;
    }
    public void grabar(Usuario usu) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.save(usu);
            tx.commit();
        }
        catch (RuntimeException ex) {
            System.out.println("ERROR EXCEPTION");
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    public void modificar(Usuario usu) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(usu);
            tx.commit();
        }
        catch (RuntimeException ex) {
            System.out.println("---------------");
            System.out.println("ERROR EXCEPTION");
            System.out.println("---------------");
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
}
