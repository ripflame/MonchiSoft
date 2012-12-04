/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.FinalProductToppings;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface FinalProductToppingsManager extends GenericManager<FinalProductToppings, Integer>{
    public List<FinalProductToppings> searchById(Integer id);
    public List<FinalProductToppings> getAll();
}
