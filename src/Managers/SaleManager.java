/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.Sale;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface SaleManager extends GenericManager<Sale, Integer>{
    public List<Sale> searchById(Integer id);
    public List<Sale> getAll();
    
}
