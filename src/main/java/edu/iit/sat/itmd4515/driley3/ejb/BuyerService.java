/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.ejb;


import edu.iit.sat.itmd4515.driley3.domain.Buyer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Daria
 */
@Stateless
public class BuyerService {

    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    public BuyerService() {
    }
    
    public void create(Buyer b){
        em.persist(b);
    }
    public void update(Buyer b){
        em.merge(b);
    }
    public void remove(Buyer b){
        em.remove(em.merge(b));
    }
    public Buyer find(Long id){
        return em.find(Buyer.class, id);
    }
    public List<Buyer> findAll(){
        return em.createNamedQuery("Buyer.findAll",Buyer.class).getResultList();
    }
}
