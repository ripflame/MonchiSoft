package Managers;

import Entities.Topping;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class ToppingManagerImplementation extends GenericManagerImplementation<Topping, Integer> implements ToppingManager {

    @Override
    public List<Topping> searchByName(String name) {
        List<Topping> toppings = null;
        toppings = HQLQueryHelper.execute(TOPPING_QUERY_NAME + 
                name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);
        
        return toppings;
    }

    @Override
    public List<Topping> searchByExactName(String name) {
        List<Topping> productList = null;
        productList = HQLQueryHelper.execute(TOPPING_QUERY_NAME + 
                name + QueryConstants.TERMINATION_CHARACTER);
        
        return productList;
    }
    
    @Override
    public List<Topping> searchById(Integer id) {
        List<Topping> toppings = null;
        toppings = HQLQueryHelper.execute(TOPPING_QUERY_ID + id 
                + QueryConstants.TERMINATION_CHARACTER);
        
        return toppings;
    }
    
    @Override
    public List<Topping> getAll() {
        List<Topping> toppings = super.getAll(Topping.class);
        
        return toppings;
    }

    private static final String TOPPING_QUERY_NAME = "from Topping t where t.name like '";
    private static final String TOPPING_QUERY_ID = "from Topping t where t.id like '";
}
