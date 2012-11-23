package Managers;

import Entities.DailyCashClosing;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class DailyCashClosingManagerImplementation extends GenericManagerImplementation<DailyCashClosing, Integer> implements DailyCashClosingManager {

    @Override
    public List<DailyCashClosing> searchByID(Integer id) {
        List<DailyCashClosing> dailyCashClosings = null;
        dailyCashClosings = HQLQueryHelper.execute(QueryConstants.DAILY_CASH_CLOSING_QUERY_ID + 
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return dailyCashClosings;
    }
    
    @Override
    public List<DailyCashClosing> getAll() {
        List<DailyCashClosing> dailyCashClosings = super.getAll(DailyCashClosing.class);
        
        return dailyCashClosings;
    }

}
