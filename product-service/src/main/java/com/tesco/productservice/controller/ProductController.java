package com.tesco.productservice.controller;


import com.tesco.productservice.dto.ProductDTO;
import com.tesco.productservice.exceptions.ResourceNotFoundException;
import com.tesco.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> handleGetAll(){
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> handleGetOne(@PathVariable Integer id){
        var data = service.getProduct(id);
        if(data==null){
            throw new ResourceNotFoundException("No data found for id " + id);
        }
        return ResponseEntity.ok(data);
    }

}
