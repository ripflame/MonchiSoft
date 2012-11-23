/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.Customer;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface CustomerManager extends GenericManager<Customer, Integer> {
    public List<Customer> searchByName(String name);
    public List<Customer> searchById(Integer id);
    public List<Customer> getAll();
}
