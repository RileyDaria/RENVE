/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Daria
 */
@Entity
public class REAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "agent")
    private List<Buyer> buyers = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "inventory_agents",
            joinColumns = @JoinColumn(name="agent_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private List<REAgent> invetories = new ArrayList<>();

    /**
     * Get the value of invetories
     *
     * @return the value of invetories
     */
    public List<REAgent> getInvetories() {
        return invetories;
    }

    /**
     * Set the value of invetories
     *
     * @param invetories new value of invetories
     */
    public void setInvetories(List<REAgent> invetories) {
        this.invetories = invetories;
    }


    /**
     * Get the value of buyers
     *
     * @return the value of buyers
     */
    public List<Buyer> getBuyers() {
        return buyers;
    }

    /**
     * Set the value of buyers
     *
     * @param buyers new value of buyers
     */
    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    private Inventory inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public REAgent() {
    }

}
