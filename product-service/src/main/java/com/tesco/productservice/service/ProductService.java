package com.tesco.productservice.service;

import com.tesco.productservice.dto.CategoryDTO;
import com.tesco.productservice.dto.ProductDTO;
import com.tesco.productservice.dto.SupplierDTO;
import com.tesco.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    @Value("${category.service.url}")
    private String categoryServiceUrl;

    @Value("${supplier.service.url}")
    private String supplierServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductDTO> getAllCategories(){
        return repo.findAll().stream().map(ProductDTO::toProductDTO).toList();
    }

    public ProductDTO getProduct(Integer id){
        var product = repo.findById(id).orElse(null);
        ProductDTO dto = ProductDTO.toProductDTO(product);
        try{
            var categoryDTO = restTemplate.getForObject(
                    categoryServiceUrl+"/"+product.getCategoryId(), CategoryDTO.class);
            dto.setCategory(categoryDTO);
        }
        catch(Exception e){
            // no category
        }
        try{
            var supplierDTO = restTemplate.getForObject(
                    supplierServiceUrl+"/"+product.getSupplierId(), SupplierDTO.class);
            dto.setSupplier(supplierDTO);
        }
        catch(Exception e){
            // no supplier
        }
        return dto;
    }
}
