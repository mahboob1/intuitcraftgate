package com.mhcl.intuitcrudpers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mhcl.intuitcrudpers.entity.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    
    //List<Purchase> findByName(String name);
    
}
