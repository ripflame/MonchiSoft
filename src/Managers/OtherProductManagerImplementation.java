package Managers;

import Entities.OtherProduct;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class OtherProductManagerImplementation extends GenericManagerImplementation<OtherProduct, Integer> implements OtherProductManager {

    @Override
    public List<OtherProduct> searchByName(String name) {
        List<OtherProduct> otherProducts = null;
        otherProducts = HQLQueryHelper.execute(OTHER_PRODUCT_QUERY_NAME + 
                name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);
        
        return otherProducts;
    }
    
    
    @Override
    public List<OtherProduct> searchByExactName(String name) {
        List<OtherProduct> productList = null;
        productList = HQLQueryHelper.execute(OTHER_PRODUCT_QUERY_NAME + 
                name + QueryConstants.TERMINATION_CHARACTER);
        
        return productList;
    }

    @Override
    public List<OtherProduct> searchById(Integer id) {
        List<OtherProduct> otherProducts = null;
        otherProducts = HQLQueryHelper.execute(OTHER_PRODUCT_QUERY_ID + 
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return otherProducts;
    }
    
    @Override
    public List<OtherProduct> getAll() {
        List<OtherProduct> otherProducts = super.getAll(OtherProduct.class);
        
        return otherProducts;
    }

    private static final String OTHER_PRODUCT_QUERY_NAME = "from OtherProduct op where op.name like '";
    private static final String OTHER_PRODUCT_QUERY_ID = "from OtherProduct op where op.id like '";
}
