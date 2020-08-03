package com.mhcl.intuitcrudpers.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
public class Payment {
    
    @Id
    //@NotBlank(message = "customerId is mandatory")
    @Column(name = "customer_id")
    @Getter @Setter
    private long customerId;
    
    //@NotBlank(message = "accountNumber is mandatory")
    @Column(name = "account_number")
    @Getter @Setter
    private long accountNumber;
    
    //@NotBlank(message = "firstName is mandatory")
    @Column(name = "firstName")
    @Getter @Setter
    private String firstName;
    
    //@NotBlank(message = "lastName is mandatory")
    @Column(name = "lastName")
    @Getter @Setter
    private String lastName;
    
    @Column(name = "emailAddress")
    @Getter @Setter
    private String emailAddress;

    @Embedded
    @Getter @Setter
    private Address address;
    
    public Payment() {}

}
