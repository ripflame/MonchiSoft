package Entities;
// Generated 18-nov-2012 18:39:09 by Hibernate Tools 3.2.1.GA



/**
 * FinalProduct generated by hbm2java
 */
public class FinalProduct  implements java.io.Serializable {


     private Integer id;
     private int baseProductId;
     private double price;

    public FinalProduct() {
    }

    public FinalProduct(int baseProduct, double price) {
       this.baseProductId = baseProduct;
       this.price = price;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getBaseProduct() {
        return this.baseProductId;
    }
    
    public void setBaseProduct(int baseProduct) {
        this.baseProductId = baseProduct;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }




}


