/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;
    private static final String SESSION_CREATION_FAILED = "Initial SessionFactory creation failed.";
    private static final String CONFIGURATION_FILE_PATH = "/Configuration/hibernate.cfg.xml";
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            SESSION_FACTORY = new AnnotationConfiguration().configure(CONFIGURATION_FILE_PATH).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex); Despreciado
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.INFO, SESSION_CREATION_FAILED, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
