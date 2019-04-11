package com.arteysoft.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        SessionFactory sessFac = hibernateConfiguration.configure();
        
        UsuarioRepository usuarioRepository = 
                        new UsuarioRepository(sessFac);
        
        UsuarioQueries consultas = 
                        new UsuarioQueries(sessFac);
        
        /*
        Usuario usu = new Usuario(
                java.util.UUID.randomUUID().toString(),
                "Pablito",
                "Zursolo"
        );
        
        usuarioRepository.grabar(usu);
        */
        
        for (DosCampos dc : consultas.obtenerCuenta()) {
            System.out.println(dc.cuenta);
            System.out.println(dc.nombre);
        }
        
        sessFac.close();
    }
}
