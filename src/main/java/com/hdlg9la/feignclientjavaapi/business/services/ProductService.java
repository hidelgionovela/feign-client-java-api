package com.hdlg9la.feignclientjavaapi.business.services;

import com.hdlg9la.feignclientjavaapi.infrastructure.entity.ProductEntity;
import com.hdlg9la.feignclientjavaapi.infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity) {
        try {
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving the product " + e);
        }
    }

    public List<ProductEntity> findAllProducts() {
        try {
            return productRepository.findAll();
        }catch (Exception e) {
            throw new RuntimeException("Error while retrieving all products " +e);
        }
    }

    public Boolean existsByName(String title){
        try {
            return productRepository.existsByTitle(title);
        }catch (Exception e) {
            throw new RuntimeException(format("Error while retrieving products by name", title), e);
        }
    }
}
