package Entities;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class SaleFinalProductsId implements java.io.Serializable{
    private int finalProductsId;
    private int saleId;
    
    public SaleFinalProductsId() {
        
    }
    
    public SaleFinalProductsId(int finalProductsId, int saleId) {
        this.finalProductsId = finalProductsId;
        this.saleId = saleId;
    }

    /**
     * @return the finalProductId
     */
    public int getFinalProductId() {
        return finalProductsId;
    }

    /**
     * @param finalProductId the finalProductId to set
     */
    public void setFinalProductId(int finalProductId) {
        this.finalProductsId = finalProductId;
    }

    /**
     * @return the saleId
     */
    public int getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FinalProductToppingsId) ) return false;
		 SaleFinalProductsId castOther = ( SaleFinalProductsId ) other; 
         
		 return (this.getFinalProductId()==castOther.getFinalProductId())
 && (this.getSaleId()==castOther.getSaleId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFinalProductId();
         result = 37 * result + this.getSaleId();
         return result;
   }
}
