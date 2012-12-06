/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.Topping;
import java.util.List;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface ToppingManager extends GenericManager<Topping, Integer> {
    
    public List<Topping> searchByName(String name);
    public List<Topping> searchByExactName(String name); 
    public List<Topping> searchById(Integer id);
    public List<Topping> getAll();
    
}
