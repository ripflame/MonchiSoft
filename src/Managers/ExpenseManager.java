/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Entities.Expense;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public interface ExpenseManager extends GenericManager<Expense, Integer>{
    
    public List<Expense> searchById(Integer id);
    public List<Expense> getAll();
    
}
