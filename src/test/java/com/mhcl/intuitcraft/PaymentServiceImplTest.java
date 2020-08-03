package com.mhcl.intuitcraft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhcl.intuitcrudpers.dto.AddressDto;
import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.mhcl.intuitcrudpers.entity.Address;
import com.mhcl.intuitcrudpers.entity.Payment;
import com.mhcl.intuitcrudpers.service.PaymentService;
import com.mhcl.intuitcrudpers.service.PaymentServiceImpl;

@RunWith(SpringRunner.class)
public class PaymentServiceImplTest {
	@TestConfiguration
    static class PaymentServiceImplTestContextConfiguration {
 
        @Bean
        public PaymentService paymentService() {
            return new PaymentServiceImpl();
        }
    }
	
	@Autowired
    private PaymentService paymentService;
 
	@Test
	public void testCreateCustomer() {
		// given
	    PaymentDto payment = new PaymentDto();
	    payment.setAccountNumber(1257);
	    AddressDto address = new AddressDto();
	    address.setCity("Toronto");
	    address.setCountry("Canada");
	    address.setProvince("Ontario");
	    address.setStreet("112 Street 1st");
	    payment.setAddressDto(address);
	    payment.setCustomerId(12348712);
	    payment.setEmailAddress("mhd.jfn@cptr.com");
	    payment.setFirstName("John");
	    payment.setLastName("Gwall");
		this.paymentService.createCustomer(payment);
		
	}
	
	@Test
	public void testChargeCreditCard() {
		// given
	    PaymentDto payment = new PaymentDto();
	    payment.setAccountNumber(1257);
	    AddressDto address = new AddressDto();
	    address.setCity("Toronto");
	    address.setCountry("Canada");
	    address.setProvince("Ontario");
	    address.setStreet("112 Street 1st");
	    payment.setAddressDto(address);
	    payment.setCustomerId(12348712);
	    payment.setEmailAddress("mhd.jfn@cptr.com");
	    payment.setFirstName("John");
	    payment.setLastName("Gwall");
		this.paymentService.chargeCreditCard(payment);
		
	}
}
