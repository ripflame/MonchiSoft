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
        expenses = HQLQueryHelper.execute(EXPENSE_QUERY_ID + 
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return expenses;
    }
    
    @Override
    public List<Expense> getAll() {
        List<Expense> expenses = super.getAll(Expense.class);
        
        return expenses;
    }

    @Override
    public List<Expense> searchBySupplier(String supplier) {
        List<Expense> expensesList = null;
        expensesList = HQLQueryHelper.execute(EXPENSE_QUERY_SUPPLIER
                + supplier + QueryConstants.SIMILAR_TERMINATION_CHARACTER);

        return expensesList;
    }
    
    private static final String EXPENSE_QUERY_ID = "from Expense e where e.id like '";
    private static final String EXPENSE_QUERY_SUPPLIER = "from Expense e where e.supplier like '";
}
