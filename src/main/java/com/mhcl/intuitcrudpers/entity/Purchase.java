package com.mhcl.intuitcrudpers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
public class Purchase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "customer_id")
    @Getter @Setter
    private long customerId;
    
	@Getter @Setter
    private String item;
    
    @Getter @Setter
    private double amount;

    public Purchase() {}

}
