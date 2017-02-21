/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.domain;

import edu.iit.sat.itmd4515.driley3.domain.Inventory;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
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
    private static Validator validator;
    private static final Logger LOG = Logger.getLogger(InventoryTest.class.getName());

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void BeforeClassTestFixure() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }
//
//    @AfterClass
//    public static void AfterClassTestFixure() {
//        emf.close();
//
//    }
//
//    @Before
//    public void BeforeEachTestMethod() {
//        em = emf.createEntityManager();
//        tx = em.getTransaction();
//
//        Inventory seed = new Inventory("Mock item", "business", new Date(), 20, 8000);
//        tx.begin();
//        em.persist(seed);
//        tx.commit();
//
//    }
//
//    @After
//    public void AfterEachTestMethod() {
//
//        Inventory seed
//                = em.createNamedQuery("Inventory.findByAddress", Inventory.class)
//                        .setParameter("address", "Mock item")
//                        .getSingleResult();
//
//        tx.begin();
//        em.remove(seed);
//        tx.commit();
//        em.close();
//
//    }
//
//    @Test
//    public void validateMinPriceSunnyDay() {
//        Inventory i1 = new Inventory("888 S Michigan", "residential", new Date(), 30, 78000);
//        Set<ConstraintViolation<Inventory>> violations = validator.validate(i1);
//        assertTrue(violations.isEmpty());
//        
//
//    }
//
//    @Test
//    public void validateMinPriceRainyDay() {
//        Inventory i1 = new Inventory("888 S Michigan", "residential", new Date(), 30, 60);
//        Set<ConstraintViolation<Inventory>> violations = validator.validate(i1);
//        
//         for(ConstraintViolation<Inventory> violation : violations){
//            LOG.info(violation.toString());
//        }
//        assertFalse(violations.isEmpty());
//        assertTrue(violations.size()==1);
//        assertEquals(violations.size(), 1);
//
//    }
//
//    @Test
//    public void varifySeedData() {
//
//        List<Inventory> seeds
//                = em.createNamedQuery("Inventory.findByAddress", Inventory.class)
//                        .setParameter("address", "Mock item")
//                        .getResultList();
//        assertEquals(seeds.size(), 1);
//        assertSame(seeds.get(0).getAddress(), "Mock item");
//
//    }
//
//    @Test
//    public void persistNewInventoryTest() {
//
//        Inventory i1 = new Inventory("5555 N Grant", "commercial", new Date(), 200, 9000);
//
//        tx.begin();
//        assertNull("ID should be null before", i1.getId());
//        em.persist(i1);
//        assertNull("ID should be null before and after", i1.getId());
//        tx.commit();
//
//        assertNotNull("ID should be not null after commit", i1.getId());
//        assertTrue("Inventory ID should be greater than zero after commit", i1.getId() > 0);
//
//    }
//
//    @Test(expected = RollbackException.class)
//    public void persistNewInventoryShouldFailRainyDayTest() {
//        Inventory seed = new Inventory("Mock item", "business", new Date(), 20, 9000);
//
//        tx.begin();
//        em.persist(seed);
//        tx.commit();
//
//    }

}
