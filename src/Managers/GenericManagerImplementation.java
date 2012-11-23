package Managers;

import Utilities.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public abstract class GenericManagerImplementation<T, ID extends Serializable> implements GenericManager<T, ID> {

    @Override
    public void add(T entity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(GenericManagerImplementation.class.getName()).log(Level.INFO, "Couldn't add entity", e);
        }
    }

    @Override
    public void modify(T entity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(GenericManagerImplementation.class.getName()).log(Level.INFO, "Couldn't modify entity", e);
        }
    }

    @Override
    public void remove(T entity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(GenericManagerImplementation.class.getName()).log(Level.INFO, "Couldn't remove entity", e);
        }
    }

    @Override
    public List getAll(Class entityClass) {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from " + entityClass.getName());
            resultList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(GenericManagerImplementation.class.getName()).log(Level.INFO, "Couldn't get all entities", e);
        }

        return resultList;
    }
}
