package com.mhcl.intuitcrudpers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    
    @Getter @Setter
    private String street;
    
    @Getter @Setter
    private String city;
    
    @Getter @Setter
    private String province;
    
    @Getter @Setter
    private String country;

    public AddressDto() {}

}
