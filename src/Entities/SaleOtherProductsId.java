package Entities;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleOtherProductsId implements java.io.Serializable{
    private int otherProductsId;
    private int saleId;
    
    public SaleOtherProductsId() {
        
    }
    
    public SaleOtherProductsId(int otherProductsId, int saleId){
        this.otherProductsId = otherProductsId;
        this.saleId = saleId;
    }

    public int getOtherProductsId() {
        return otherProductsId;
    }

    public void setOtherProductsId(int otherProductsId) {
        this.otherProductsId = otherProductsId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SaleOtherProductsId) ) return false;
		 SaleOtherProductsId castOther = ( SaleOtherProductsId ) other; 
         
		 return (this.getOtherProductsId()==castOther.getOtherProductsId())
 && (this.getSaleId()==castOther.getSaleId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getOtherProductsId();
         result = 37 * result + this.getSaleId();
         return result;
   }
}
