package com.mhcl.intuitcrudpers.controller;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.mhcl.intuitcrudpers.entity.Payment;
import com.mhcl.intuitcrudpers.entity.Purchase;
import com.mhcl.intuitcrudpers.repository.PaymentRepository;
import com.mhcl.intuitcrudpers.repository.PurchaseRepository;
import com.mhcl.intuitcrudpers.service.PaymentService;
import com.mhcl.intuitcrudpers.transformer.PurchaseTransformer;
import com.mhcl.intuitcrudpers.transformer.PymentTransformer;

@RestController
@RequestMapping("/payment/")
public class PaymentController {
	private static final Logger logger 
	  = LoggerFactory.getLogger(PaymentController.class);

	private final PaymentRepository paymentRepository;
	private final PurchaseRepository purchaseRepository;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentRepository paymentRepository, PurchaseRepository purchaseRepository) {
		this.paymentRepository = paymentRepository;
		this.purchaseRepository = purchaseRepository;
	}

	@GetMapping("listpayment")
	public Iterable<Payment> listPaymentAll() {
		return paymentRepository.findAll();
	}
	
	@GetMapping("listorder")
	public Iterable<Purchase> listOrderAll() {
		return purchaseRepository.findAll();
	}
	
	public Validator getValidator() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        return validator;
	}
	@PostMapping("add")
	public Purchase addPayment(@RequestBody PaymentDto paymentDto) {
		boolean isStripeGateway = false;
		if(isStripeGateway) {
			try {
				String customerId = this.paymentService.createCustomer(paymentDto);
				if(customerId != null) {
					this.paymentService.chargeCreditCard(paymentDto);
				}  
			} catch(Exception e) {
				return null;
			}
		}
		PymentTransformer pymentTransformer = new PymentTransformer();
		PurchaseTransformer purchaseTransformer = new PurchaseTransformer();
 
		final Payment payment = pymentTransformer.transformPaymnetDtoToPayment(paymentDto);
		Set<ConstraintViolation<Payment>> constraintViolations = this.getValidator().validate(payment);
		//Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Payment> violation : constraintViolations) {
                logger.info(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
        Purchase purchase = purchaseTransformer.transformPaymnetDtoToPurchase(paymentDto);
        // if customer and account is already present no need to save
        Payment paymentRetrieved = paymentRepository.findById(payment.getCustomerId()).
        		orElseGet(() -> {logger.info("Invalid customer Id"); return payment;});
        if(paymentRetrieved != null) {
        	paymentRepository.save(payment);
        }
		return this.purchaseRepository.save(purchase);
	}

}
