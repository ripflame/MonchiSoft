package Managers;

import Entities.SaleFinalProducts;
import Entities.SaleOtherProducts;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleOtherProductsManagerImplementation extends GenericManagerImplementation<SaleOtherProducts, Integer> implements SaleOtherProductsManager{

    @Override
    public List<SaleOtherProducts> searchById(Integer id) {
        List<SaleOtherProducts> saleOtherProducts = null;
        saleOtherProducts = HQLQueryHelper.execute(SALE_OTHER_PRODUCT_QUERY_ID + id + QueryConstants.TERMINATION_CHARACTER);
        
        return saleOtherProducts;
    }

    @Override
    public List<SaleOtherProducts> getAll() {
        List<SaleOtherProducts> saleOtherProducts = super.getAll(SaleOtherProducts.class);
        
        return saleOtherProducts;
    }
    
    private static final String SALE_OTHER_PRODUCT_QUERY_ID = "from SaleOtherProdutcs sop where sop.id like '";

}
