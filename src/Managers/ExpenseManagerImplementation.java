package Managers;

import Entities.Expense;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class ExpenseManagerImplementation extends GenericManagerImplementation<Expense, Integer> implements ExpenseManager {

    @Override
    public List<Expense> searchById(Integer id) {
        List<Expense> expenses = null;
        expenses = HQLQueryHelper.execute(QueryConstants.EXPENSE_QUERY_ID + 
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return expenses;
    }
    
    @Override
    public List<Expense> getAll() {
        List<Expense> expenses = super.getAll(Expense.class);
        
        return expenses;
    }

}
