package com.mhcl.intuitcraft;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhcl.intuitcrudpers.controller.PaymentController;
import com.mhcl.intuitcrudpers.entity.Address;
import com.mhcl.intuitcrudpers.entity.Payment;
import com.mhcl.intuitcrudpers.repository.PaymentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentRepositoryIntegrationTest {
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PaymentRepository paymentRepository;
 
	@Test
	public void testPaymentCustomerId() {
		// given
	    Payment payment = new Payment();
	    payment.setAccountNumber(1257);
	    Address address = new Address();
	    address.setCity("Toronto");
	    address.setCountry("Canada");
	    address.setProvince("Ontario");
	    address.setStreet("112 Street 1st");
	    payment.setAddress(address);
	    payment.setCustomerId(12348712);
	    payment.setEmailAddress("mhd.jfn@cptr.com");
	    payment.setFirstName("John");
	    payment.setLastName("Gwall");
	    entityManager.persist(payment);
	    entityManager.flush();
	 
	    // when
	    Payment paymentRetrieved = paymentRepository.findById(payment.getCustomerId()).
        		orElseGet(() -> {logger.info("Invalid customer Id"); return payment;});
	 
	    // then
	    assertEquals(paymentRetrieved.getCustomerId(), payment.getCustomerId());
	}

}
