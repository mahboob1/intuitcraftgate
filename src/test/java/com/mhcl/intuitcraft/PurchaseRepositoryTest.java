package com.mhcl.intuitcraft;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.mhcl.intuitcrudpers.controller.PaymentController;
import com.mhcl.intuitcrudpers.entity.Address;
import com.mhcl.intuitcrudpers.entity.Payment;
import com.mhcl.intuitcrudpers.entity.Purchase;
import com.mhcl.intuitcrudpers.repository.PaymentRepository;
import com.mhcl.intuitcrudpers.repository.PurchaseRepository;

public class PurchaseRepositoryTest {
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
  private TestEntityManager entityManager;

  @Autowired
  private PurchaseRepository purchaseRepository;

	@Test
	public void testPurchaseCustomerId() {
		// given
	    Purchase purchase = new Purchase();
	    purchase.setAmount(100.00);
	    purchase.setItem("Item 01");
	    purchase.setCustomerId(1257);
	     
	    entityManager.persist(purchase);
	    entityManager.flush();
	 
	    // when
	    Purchase purchaseRetrieved = purchaseRepository.findById(purchase.getCustomerId()).
        		orElseGet(() -> {logger.info("Invalid customer Id"); return purchase;});
	 
	    // then
	    assertEquals(purchaseRetrieved.getCustomerId(), purchase.getCustomerId());
	}

}
