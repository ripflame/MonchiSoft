package Entities;
// Generated 18-nov-2012 18:39:09 by Hibernate Tools 3.2.1.GA

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

    public Customer() {
        this.id = 0;
        this.name = "";
    }

    public Customer(String name) {
        this.name = name;
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
    private Integer id;
    private String name;
}
