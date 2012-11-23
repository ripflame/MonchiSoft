package Managers;

import Entities.FinalProduct;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class FinalProductManagerImplementation extends GenericManagerImplementation<FinalProduct, Integer> implements FinalProductManager {

    @Override
    public List<FinalProduct> searchById(Integer id) {
        List<FinalProduct> finalProducts = null;
        finalProducts = HQLQueryHelper.execute(QueryConstants.FINAL_PRODUCT_QUERY_ID +
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return finalProducts;
    }

    @Override
    public List<FinalProduct> getAll() {
        List<FinalProduct> finalProducts = super.getAll(FinalProduct.class);
        
        return finalProducts;
    }

}
