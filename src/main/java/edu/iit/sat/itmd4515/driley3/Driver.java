/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3;

import edu.iit.sat.itmd4515.driley3.domain.Inventory;
import edu.iit.sat.itmd4515.driley3.domain.Seller;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Daria
 */
public class Driver {

    private static final Logger LOG = Logger.getLogger(Driver.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Inventory i1 = new Inventory("8777 SN Michigan Street","residential",new Date(),20, 80000);
        Seller s1 = new Seller("Bob", "Johnson");
        
        tx.begin();
        em.persist(i1);
        em.persist(s1);
        tx.commit();
        
        i1 = em.createNamedQuery("Inventory.findByAddress", Inventory.class).getSingleResult();
        
        System.out.println("######### " + i1.getAddress());
        
        em.close();
        emf.close();
  }

}
