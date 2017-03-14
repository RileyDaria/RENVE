/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import edu.iit.sat.itmd4515.driley3.domain.Inventory;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Daria
 */
@Entity
@Table(name = "seller")
public class Seller extends NamedEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Seller(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
//        inventory.setSeller(this);
    }

    public void addInventory(Inventory i) {
        this.inventory = i;
        i.setSeller(this);
    }

    public Seller() {
    }

}
