package Entities;
// Generated 18-nov-2012 18:39:09 by Hibernate Tools 3.2.1.GA

/**
 * BaseProduct generated by hbm2java
 */
public class BaseProduct implements java.io.Serializable {

    public BaseProduct() {
        this.id = 0;
        this.name = "";
        this.smallPrice = 0;
        this.mediumPrice = 0;
        this.largePrice = 0;
    }

    public BaseProduct(String name, double smallPrice, double mediumPrice, double largePrice) {
        this.name = name;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSmallPrice() {
        return this.smallPrice;
    }

    public void setSmallPrice(double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public double getMediumPrice() {
        return this.mediumPrice;
    }

    public void setMediumPrice(double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public double getLargePrice() {
        return this.largePrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }
    private Integer id;
    private String name;
    private double smallPrice;
    private double mediumPrice;
    private double largePrice;
}
