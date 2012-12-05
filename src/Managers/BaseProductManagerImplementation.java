package Managers;

import Entities.BaseProduct;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class BaseProductManagerImplementation extends GenericManagerImplementation<BaseProduct, Integer> implements BaseProductManager {

    @Override
    public List<BaseProduct> searchByName(String name) {
        List<BaseProduct> productList = null;
        productList = HQLQueryHelper.execute(BASE_PRODUCT_QUERY_NAME + 
                name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);
        
        return productList;
    }
    
    
    @Override
    public List<BaseProduct> searchByExactName(String name) {
        List<BaseProduct> productList = null;
        productList = HQLQueryHelper.execute(BASE_PRODUCT_QUERY_NAME + 
                name + QueryConstants.TERMINATION_CHARACTER);
        
        return productList;
    }

    @Override
    public List<BaseProduct> searchById(Integer id) {
        List<BaseProduct> productList = null;
        productList = HQLQueryHelper.execute(BASE_PRODUCT_QUERY_ID +
                id + QueryConstants.TERMINATION_CHARACTER);
        
        return productList;
    }
    
    @Override
    public List<BaseProduct> getAll() {
        List<BaseProduct> baseProducts = super.getAll(BaseProduct.class);
        
        return baseProducts;
    }

    private static final String BASE_PRODUCT_QUERY_NAME = "from BaseProduct bp where bp.name like '";
    private static final String BASE_PRODUCT_QUERY_ID = "from BaseProduct bp where bp.id like '";
}
