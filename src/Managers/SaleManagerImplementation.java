package Managers;

import Entities.Sale;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleManagerImplementation extends GenericManagerImplementation<Sale, Integer> implements SaleManager {

    @Override
    public List<Sale> searchById(Integer id) {
        List<Sale> sales = null;
        sales = HQLQueryHelper.execute(QueryConstants.SALE_QUERY_ID +
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return sales;
    }

    @Override
    public List<Sale> getAll() {
        List<Sale> sales = super.getAll(Sale.class);
        
        return sales;
    }

}
