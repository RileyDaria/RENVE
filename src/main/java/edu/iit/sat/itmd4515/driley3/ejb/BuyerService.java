/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.ejb;

import edu.iit.sat.itmd4515.driley3.domain.Buyer;
import edu.iit.sat.itmd4515.driley3.domain.REAgent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daria
 */
@Stateless
public class BuyerService extends BaseService<Buyer> {

    public BuyerService() {
        super(Buyer.class);
    }
    

    @Override
    public List<Buyer> findAll() {
         return getEntityManager().createNamedQuery("Buyer.findAll", Buyer.class).getResultList();
    }
    
    
}
