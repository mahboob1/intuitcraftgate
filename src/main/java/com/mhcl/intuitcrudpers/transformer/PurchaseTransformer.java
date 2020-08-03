package com.mhcl.intuitcrudpers.transformer;

import com.mhcl.intuitcrudpers.dto.PaymentDto;
import com.mhcl.intuitcrudpers.entity.Purchase;

public class PurchaseTransformer {
	public Purchase transformPaymnetDtoToPurchase(PaymentDto paymentDto) {
		Purchase purchase = new Purchase();
		purchase.setCustomerId(paymentDto.getCustomerId());
		purchase.setAmount(paymentDto.getPurchaseDto().getAmount());
		purchase.setItem(paymentDto.getPurchaseDto().getItem());
		return purchase;
	}
	
}
