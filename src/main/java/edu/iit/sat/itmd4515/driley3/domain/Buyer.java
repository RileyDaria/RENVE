/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Daria
 */
@Entity
public class Buyer extends NamedEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private REAgent agent;
    @OneToOne
    private Inventory inventory;

    public Buyer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public Buyer() {
    }

}
