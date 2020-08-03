package com.mhcl.intuitcrudpers.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Embeddable
public class Address {
    
    @Column(name = "street")
    @Getter @Setter
    private String street;
    
    @Column(name = "city")
    @Getter @Setter
    private String city;
    
    @Column(name = "province")
    @Getter @Setter
    private String province;
    
    @Column(name = "country")
    @Getter @Setter
    private String country;

    public Address() {}

}
