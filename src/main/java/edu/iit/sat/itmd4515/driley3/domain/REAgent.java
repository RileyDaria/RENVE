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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author Daria
 */
@Entity
public class REAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @OneToMany(mappedBy = "agent")
    private List<Buyer> buyers = new ArrayList<>();
    
    

    public REAgent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @ManyToMany(mappedBy = "agents")
    private List<Inventory> inventories = new ArrayList<>();
    
   // this method doesnt work for some reason
    public void addInventory(Inventory i){
        this.inventories.add(i);
        i.getAgents().add(this);
    }

    /**
     * Get the value of inventories
     *
     * @return the value of inventories
     */
    public List<Inventory> getInventories() {
        return inventories;
    }

    /**
     * Set the value of inventories
     *
     * @param inventories new value of inventories
     */
    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
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

    public REAgent() {
    }



}
