package Entities;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleFinalProducts implements java.io.Serializable {
    private SaleFinalProductsId id;
    
    public SaleFinalProducts() {
        
    }
    
    public SaleFinalProducts(SaleFinalProductsId id) {
        this.id = id;
    }

    public SaleFinalProductsId getId() {
        return id;
    }

    public void setId(SaleFinalProductsId id) {
        this.id = id;
    }
}
