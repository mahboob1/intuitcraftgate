package com.mhcl.intuitcrudpers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mhcl.intuitcrudpers.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    
    //List<Payment> findByName(String name);
    
}
