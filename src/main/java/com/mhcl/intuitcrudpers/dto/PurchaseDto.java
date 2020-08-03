package com.mhcl.intuitcrudpers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseDto {
	
//	@Getter @Setter
//    private long id;
//	
//	
//    @Getter @Setter
//    private long customerId;
    
    @Getter @Setter
    private String item;
    
    @Getter @Setter
    private double amount;
    
    public PurchaseDto() {}

}
