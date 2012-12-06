package Entities;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleOtherProducts implements java.io.Serializable {
    private SaleOtherProductsId id;
    private int quantity;
    
    public SaleOtherProducts() {
        
    }
    
    public SaleOtherProducts(SaleOtherProductsId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public SaleOtherProductsId getId() {
        return id;
    }

    public void setId(SaleOtherProductsId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
