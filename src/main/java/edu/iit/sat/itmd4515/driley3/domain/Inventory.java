/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daria
 */
@Entity
@Table(name = "inventory")
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i from Inventory i")
    ,
    @NamedQuery(name = "Inventory.findByAddress", query = "SELECT i from Inventory i where i.address = :address")
})
public class Inventory {

    //no-args constructor
    public Inventory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull(message = "The address cannot be null")
    private String address;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    @Transient
    private Integer size;
    @Min(1000)//A thousand dollar minimum
    private float price;
    
    @OneToOne(mappedBy ="inventory")
    private Seller seller;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", address=" + address + ", type=" + type + ", dateEntered=" + dateEntered + ", size=" + size + '}';
    }

    public Inventory(String address, String type, Date dateEntered, Integer size) {
        this.address = address;
        this.type = type;
        this.dateEntered = dateEntered;
        this.size = size;
    }

    public Inventory(String address, String type, Date dateEntered, Integer size, float price) {
        this.address = address;
        this.type = type;
        this.dateEntered = dateEntered;
        this.size = size;
        this.price = price;
    }


    /**
     * Get the value of size
     *
     * @return the value of size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Set the value of size
     *
     * @param size new value of size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Get the value of dateEntered
     *
     * @return the value of dateEntered
     */
    public Date getDateEntered() {
        return dateEntered;
    }

    /**
     * Set the value of dateEntered
     *
     * @param dateEntered new value of dateEntered
     */
    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
