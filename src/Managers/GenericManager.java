/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface GenericManager<T, ID extends Serializable> {
    public void add(T entity);
    public void modify(T entity);
    public void remove(T entity);
    public List getAll(Class entityClass);
}
