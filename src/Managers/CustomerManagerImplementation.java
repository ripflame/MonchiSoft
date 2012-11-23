package Managers;

import Entities.Customer;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class CustomerManagerImplementation extends GenericManagerImplementation<Customer, Integer> implements CustomerManager {

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customersList = null;
        customersList = HQLQueryHelper.execute(QueryConstants.CUSTOMER_QUERY_NAME
                + name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);

        return customersList;
    }

    @Override
    public List<Customer> searchById(Integer id) {
        List<Customer> customerList = null;
        customerList = HQLQueryHelper.execute(QueryConstants.CUSTOMER_QUERY_ID
                + id + QueryConstants.TERMINATION_CHARACTER);

        return customerList;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = super.getAll(Customer.class);

        return customers;
    }
}
