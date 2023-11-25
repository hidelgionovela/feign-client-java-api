package com.hdlg9la.feignclientjavaapi.infrastructure.repositories;

import com.hdlg9la.feignclientjavaapi.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Boolean existsByTitle(String title);
}
