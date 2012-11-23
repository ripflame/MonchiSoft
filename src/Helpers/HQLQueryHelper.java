package Helpers;

import Managers.CustomerManagerImplementation;
import Utilities.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class HQLQueryHelper {
    
    public static List execute(String query) {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query queryToExecute = session.createQuery(query);
            resultList = queryToExecute.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Logger.getLogger(CustomerManagerImplementation.class.getName()).log(Level.INFO, "Couldn't execute query", e);
        }
        
        return resultList;
    }
    
}
