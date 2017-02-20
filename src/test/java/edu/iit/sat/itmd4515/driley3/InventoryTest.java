/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Daria
 */
public class InventoryTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void BeforeClassTestFixure() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");

    }

    @AfterClass
    public static void AfterClassTestFixure() {
        emf.close();

    }

    @Before
    public void BeforeEachTestMethod() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Inventory seed = new Inventory("Mock item", "business", new Date(), 20);
        tx.begin();
        em.persist(seed);
        tx.commit();

    }

    @After
    public void AfterEachTestMethod() {

        Inventory seed
                = em.createNamedQuery("Inventory.findByAddress", Inventory.class)
                        .setParameter("address", "Mock item")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();
        em.close();

    }

    @Test
    public void varifySeedData() {

        List<Inventory> seeds
                = em.createNamedQuery("Inventory.findByAddress", Inventory.class)
                        .setParameter("address", "Mock item")
                        .getResultList();
        assertEquals(seeds.size(), 1);
        assertSame(seeds.get(0).getAddress(), "Mock item");

    }

    @Test
    public void persistNewInventoryTest() {

        Inventory i1 = new Inventory("5555 N Grant", "commercial", new Date(), 200);

        tx.begin();
        assertNull("ID should be null before", i1.getId());
        em.persist(i1);
        assertNull("ID should be null before and after", i1.getId());
        tx.commit();

        assertNotNull("ID should be not null after commit", i1.getId());
        assertTrue("Inventory ID should be greater than zero after commit", i1.getId() > 0);

    }

    @Test(expected = RollbackException.class)
    public void persistNewInventoryShouldFailRainyDayTest() {
        Inventory seed = new Inventory("Mock item", "business", new Date(), 20);

        tx.begin();
        em.persist(seed);
        tx.commit();

    }

}
