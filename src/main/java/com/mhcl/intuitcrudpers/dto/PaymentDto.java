package com.mhcl.intuitcrudpers.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDto {
    
    @NotBlank(message = "customerId is mandatory")
    @Getter @Setter
    private long customerId;
    
    @NotBlank(message = "accountNumber is mandatory")
    @Getter @Setter
    private long accountNumber;
    
    @NotBlank(message = "firstName is mandatory")
    @Getter @Setter
    private String firstName;
    
    @NotBlank(message = "lastName is mandatory")
    @Getter @Setter
    private String lastName;
    
    @Getter @Setter
    private String emailAddress;

    @Getter @Setter
    private AddressDto addressDto;
    
    @Getter @Setter
    private PurchaseDto purchaseDto;
    
    public PaymentDto() {}

}
