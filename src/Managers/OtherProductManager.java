/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.OtherProduct;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface OtherProductManager extends GenericManager<OtherProduct, Integer>{
    
    public List<OtherProduct> searchByName(String name);
    public List<OtherProduct> searchById(Integer id);
    public List<OtherProduct> getAll();
    
}
