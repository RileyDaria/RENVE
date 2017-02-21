/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Daria
 */
@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private REAgent agent;
    @OneToOne
    private Inventory inventory;

    /**
     * Get the value of agent
     *
     * @return the value of agent
     */
    public REAgent getAgent() {
        return agent;
    }

    /**
     * Set the value of agent
     *
     * @param agent new value of agent
     */
    public void setAgent(REAgent agent) {
        this.agent = agent;
    }

   

    @Override
    public String toString() {
        return "Buyer{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

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

    public Buyer() {
    }

}
