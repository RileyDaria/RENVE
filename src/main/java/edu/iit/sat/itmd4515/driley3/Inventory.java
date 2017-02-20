/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Daria
 */
@Entity
@Table(name = "inventory")
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i from Inventory i"),
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
    private String address;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    @Transient
    private Integer size;

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

    public Inventory(String address, String type, Integer size) {
        this.address = address;
        this.type = type;
        this.size = size;
    }

    public Inventory(Long id, String address, String type, Integer size) {
        this.id = id;
        this.address = address;
        this.type = type;
        //this.dateEntered = dateEntered;
        this.size = size;
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
