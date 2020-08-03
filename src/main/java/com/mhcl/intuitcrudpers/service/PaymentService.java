package com.mhcl.intuitcrudpers.service;

import com.mhcl.intuitcrudpers.dto.PaymentDto;

public interface PaymentService {
	  public String createCustomer(PaymentDto user);
	  public void chargeCreditCard(PaymentDto order);
	}
