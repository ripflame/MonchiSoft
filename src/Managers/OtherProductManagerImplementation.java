package Managers;

import Entities.OtherProduct;
import Helpers.QueryConstants;
import Helpers.HQLQueryHelper;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class OtherProductManagerImplementation extends GenericManagerImplementation<OtherProduct, Integer> implements OtherProductManager {

    @Override
    public List<OtherProduct> searchByName(String name) {
        List<OtherProduct> otherProducts = null;
        otherProducts = HQLQueryHelper.execute(QueryConstants.OTHER_PRODUCT_QUERY_NAME + 
                name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);
        
        return otherProducts;
    }

    @Override
    public List<OtherProduct> searchById(Integer id) {
        List<OtherProduct> otherProducts = null;
        otherProducts = HQLQueryHelper.execute(QueryConstants.OTHER_PRODUCT_QUERY_ID + 
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return otherProducts;
    }
    
    @Override
    public List<OtherProduct> getAll() {
        List<OtherProduct> otherProducts = super.getAll(OtherProduct.class);
        
        return otherProducts;
    }

}
