package com.mhcl.intuitcraft;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mhcl.intuitcrudpers.controller.PaymentController;
import com.mhcl.intuitcrudpers.dto.AddressDto;
import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.mhcl.intuitcrudpers.service.PaymentService;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private PaymentService service; 
    
    @Test
    public void addPayment()
      throws Exception {
        
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
     
        mvc.perform(post("/payment/add")
          .contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void listAll()
      throws Exception {
        
        mvc.perform(post("/payment/list")
          .contentType(MediaType.APPLICATION_JSON));
    }

}
