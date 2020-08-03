package com.mhcl.intuitcrudpers.transformer;

import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.mhcl.intuitcrudpers.entity.Address;
import com.mhcl.intuitcrudpers.entity.Payment;

public class PymentTransformer {
	public Payment transformPaymnetDtoToPayment(PaymentDto PaymentDto) {
		Payment payment = new Payment();
		payment.setAccountNumber(PaymentDto.getAccountNumber());
		payment.setCustomerId(PaymentDto.getCustomerId());
		payment.setEmailAddress(PaymentDto.getEmailAddress());
		payment.setFirstName(PaymentDto.getFirstName());
		payment.setLastName(PaymentDto.getLastName());
		payment.setAddress(new Address());
		payment.getAddress().setCity(PaymentDto.getAddressDto().getCity());
		payment.getAddress().setCountry(PaymentDto.getAddressDto().getCountry());
		payment.getAddress().setProvince(PaymentDto.getAddressDto().getProvince());
		payment.getAddress().setStreet(PaymentDto.getAddressDto().getStreet());
		return payment;
	}
}
