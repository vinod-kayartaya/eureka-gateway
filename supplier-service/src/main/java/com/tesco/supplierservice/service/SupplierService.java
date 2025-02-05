package com.tesco.supplierservice.service;

import com.tesco.supplierservice.dto.SupplierDTO;
import com.tesco.supplierservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repo;

    public List<SupplierDTO> getAllSuppliers(){
        return repo.findAll().stream().map(SupplierDTO::toSupplierDTO).toList();
    }

    public SupplierDTO getSupplier(Integer id){
        var supplier = repo.findById(id).orElse(null);
        return SupplierDTO.toSupplierDTO(supplier);
    }
}

