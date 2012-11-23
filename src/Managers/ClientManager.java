/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.Costumer;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface ClientManager extends GenericManager<Costumer, Integer> {
    public List<Costumer> searchByName(String name);
    public List<Costumer> searchById(Integer id);
    public List<Costumer> getAll();
}
