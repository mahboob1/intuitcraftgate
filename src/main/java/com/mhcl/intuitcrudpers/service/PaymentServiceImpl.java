package com.mhcl.intuitcrudpers.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	
  private static final Logger logger 
	  = LoggerFactory.getLogger(PaymentServiceImpl.class);

  private static final String TEST_STRIPE_SECRET_KEY = "sk_test_XXXXX";

  public PaymentServiceImpl() {
    Stripe.apiKey = TEST_STRIPE_SECRET_KEY;
  }

  public String createCustomer(PaymentDto user) {
	
    Map<String, Object> customerParams = new HashMap<String, Object>();
    customerParams.put("description", 
      user.getFirstName() + " " + user.getLastName());
	customerParams.put("email", user.getEmailAddress());
		
	String id = null;
		
	try { 
      // Create customer
	  Customer stripeCustomer = Customer.create(customerParams);
	  id = stripeCustomer.getId();
	  logger.info(stripeCustomer.toString());
	} catch (CardException e) {
	  // Transaction failure
	} catch (RateLimitException e) {
	  // Too many requests made to the API too quickly
	} catch (InvalidRequestException e) {
	  // Invalid parameters were supplied to Stripe's API
	} catch (AuthenticationException e) {
	  // Authentication with Stripe's API failed (wrong API key?)
	} catch (APIConnectionException e) {
	  // Network communication with Stripe failed
	} catch (StripeException e) {
	  // Generic error
	} catch (Exception e) {
	// Something else unrelated to Stripe
	}
	
    return id;	
  }
  
  public void chargeCreditCard(PaymentDto order) {
		
	    // Stripe requires the charge amount to be in cents
	    int chargeAmountCents = (int) order.getPurchaseDto().getAmount() * 100;

		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", chargeAmountCents);
		chargeParams.put("currency", "usd");
		chargeParams.put("description", "Monthly Charges");		
		chargeParams.put("customer", order.getCustomerId());
				
		try {
		  // Submit charge to credit card 
		  Charge charge = Charge.create(chargeParams);
		  logger.info(charge.toString());
	    } catch (CardException e) {
		  // Transaction was declined
	    	logger.info("Status is: " + e.getCode());
	    	logger.info("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
		  // Invalid parameters were supplied to Stripe's API
	    } catch (AuthenticationException e) {
		  // Authentication with Stripe's API failed (wrong API key?)
		} catch (APIConnectionException e) {
		  // Network communication with Stripe failed
		 } catch (StripeException e) {
		  // Generic error
		} catch (Exception e) {
		  // Something else happened unrelated to Stripe
		}	
	  }
	}
