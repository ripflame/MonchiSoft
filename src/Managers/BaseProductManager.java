/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.BaseProduct;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface BaseProductManager extends GenericManager<BaseProduct, Integer> {
    
    public List<BaseProduct> searchByName(String name);
    public List<BaseProduct> searchById(Integer id);
    public List<BaseProduct> getAll();
    
}
