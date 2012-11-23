package Managers;

import Entities.Costumer;
import Helpers.HQLQueryHelper;
import Helpers.QueryConstants;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class ClientManagerImplementation extends GenericManagerImplementation<Costumer, Integer> implements ClientManager {

    @Override
    public List<Costumer> searchByName(String name) {
        List<Costumer> clientsList = null;
        clientsList = HQLQueryHelper.execute(QueryConstants.COSTUMER_QUERY_NAME
                + name + QueryConstants.SIMILAR_TERMINATION_CHARACTER);

        return clientsList;
    }

    @Override
    public List<Costumer> searchById(Integer id) {
        List<Costumer> clientList = null;
        clientList = HQLQueryHelper.execute(QueryConstants.COSTUMER_QUERY_ID
                + id + QueryConstants.TERMINATION_CHARACTER);

        return clientList;
    }

    @Override
    public List<Costumer> getAll() {
        List<Costumer> clients = super.getAll(Costumer.class);

        return clients;
    }
}
