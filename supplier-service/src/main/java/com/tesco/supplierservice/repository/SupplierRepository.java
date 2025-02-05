package com.tesco.supplierservice.repository;

import com.tesco.supplierservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
