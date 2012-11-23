/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.FinalProduct;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface FinalProductManager extends GenericManager<FinalProduct, Integer>{
    public List<FinalProduct> searchById(Integer id);
    public List<FinalProduct> getAll();
    
}
