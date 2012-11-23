/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.DailyCashClosing;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface DailyCashClosingManager extends GenericManager<DailyCashClosing, Integer> {
    
    public List<DailyCashClosing> searchByID(Integer id);
    public List<DailyCashClosing> getAll();
    
}
