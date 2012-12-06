package Managers;

import Entities.FinalProductToppings;
import Entities.SaleFinalProducts;
import Entities.SaleFinalProductsId;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleFinalProductsManagerImplementation extends GenericManagerImplementation<SaleFinalProducts, Integer> implements SaleFinalProductsManager{

    @Override
    public List<SaleFinalProducts> searchById(Integer id) {
        List<SaleFinalProducts> saleFinalProducts = null;
        saleFinalProducts = HQLQueryHelper.execute(SALE_FINAL_PRODUCT_QUERY_ID + id + QueryConstants.TERMINATION_CHARACTER);
        
        return saleFinalProducts;
    }

    @Override
    public List<SaleFinalProducts> getAll() {
        List<SaleFinalProducts> saleFinalProducts = super.getAll(SaleFinalProducts.class);
        
        return saleFinalProducts;
    }
    
    private static final String SALE_FINAL_PRODUCT_QUERY_ID = "from SaleFinalProdutcs sfp where sfp.id like '";

}
