package Entities;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleOtherProducts implements java.io.Serializable {
    private SaleOtherProductsId id;
    
    public SaleOtherProducts() {
        
    }
    
    public SaleOtherProducts(SaleOtherProductsId id) {
        this.id = id;
    }

    public SaleOtherProductsId getId() {
        return id;
    }

    public void setId(SaleOtherProductsId id) {
        this.id = id;
    }
}
