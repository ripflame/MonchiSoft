/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.SaleOtherProducts;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface SaleOtherProductsManager extends GenericManager<SaleOtherProducts, Integer>{
    public List<SaleOtherProducts> searchById(Integer id);
    public List<SaleOtherProducts> getAll();
}
