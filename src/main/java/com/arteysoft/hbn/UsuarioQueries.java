package com.arteysoft.hbn;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UsuarioQueries {
    private SessionFactory sessionFactory;

    public UsuarioQueries(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Usuario> obtenerTodosLosUsuarios() {
        // from Usuario
        // from Usuario u where u.nombre = 'Marcos'
        // from Usuario u order by nombre
        
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("from Usuario u order by nombre desc");
        List<Usuario> ret = q.list();
        sess.close();
        return ret;
    }
    public List<Object[]> obtenerSoloAlgunasColumnas() {
        // select count(*), nombre from Usuario u group by u.nombre
        // select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) from usuario u
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("select count(*), nombre from Usuario u group by u.nombre");
        List<Object[]> ret = q.list();
        sess.close();
        return ret;
    }
    public List<DosCampos> obtenerCuenta() {
        // select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) 
        // from usuario u
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) from Usuario u group by u.nombre");
        List<DosCampos> ret = q.list();
        sess.close();
        return ret;
    }
    public String obtenerValorUnico() {
        return null;
    }
}
