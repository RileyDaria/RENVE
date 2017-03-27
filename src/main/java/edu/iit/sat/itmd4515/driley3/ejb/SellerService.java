/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.driley3.ejb;

import edu.iit.sat.itmd4515.driley3.domain.Buyer;
import edu.iit.sat.itmd4515.driley3.domain.Seller;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Daria
 */
public class SellerService extends BaseService<Seller>{

    public SellerService() {
        super(Seller.class);
    }

    @Override
    public List<Seller> findAll() {
       return getEntityManager().createNamedQuery("Seller.findAll", Seller.class).getResultList();
    }
    
    


    
}
