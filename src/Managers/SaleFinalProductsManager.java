/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.SaleFinalProducts;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface SaleFinalProductsManager extends GenericManager<SaleFinalProducts, Integer>{
    public List<SaleFinalProducts> searchById(Integer id);
    public List<SaleFinalProducts> getAll();
}
