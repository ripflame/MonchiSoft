package Entities;
// Generated 18-nov-2012 18:39:09 by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * DailyCashClosing generated by hbm2java
 */
public class DailyCashClosing implements java.io.Serializable {

    public DailyCashClosing() {
        this.id = 0;
        this.dateEnd = null;
        this.total = 0;
    }

    public DailyCashClosing(Date dateEnd, double total) {
        this.dateEnd = dateEnd;
        this.total = total;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    private Integer id;
    private Date dateEnd;
    private double total;
}
