package Managers;

import Entities.FinalProductToppings;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class FinalProductToppingsManagerImplementation  extends GenericManagerImplementation<FinalProductToppings, Integer> implements FinalProductToppingsManager{
    private static final String FINAL_PRODUCT_TOPPINGS_QUERY_ID = "from FinalProductToppings fpt where fpt.id like '";
    
    @Override
    public List<FinalProductToppings> searchById(Integer id) {
        List<FinalProductToppings> finalProductToppings = null;
        finalProductToppings = HQLQueryHelper.execute(FINAL_PRODUCT_TOPPINGS_QUERY_ID + id + QueryConstants.TERMINATION_CHARACTER);
        
        return finalProductToppings;
    }

    @Override
    public List<FinalProductToppings> getAll() {
        List<FinalProductToppings> finalProductToppings = super.getAll(FinalProductToppings.class);
        
        return finalProductToppings;
    }

}
