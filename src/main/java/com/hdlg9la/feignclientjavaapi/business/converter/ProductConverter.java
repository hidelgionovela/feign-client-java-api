package com.hdlg9la.feignclientjavaapi.business.converter;

import com.hdlg9la.feignclientjavaapi.apiv1.dto.ProductsDTO;
import com.hdlg9la.feignclientjavaapi.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Component
public class ProductConverter {

    public ProductEntity toEntity(ProductsDTO dto){
        return ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .title(dto.getTitle())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .image(dto.getImage())
                .inclusionDate(LocalDateTime.now())
                .build();
    }

    public ProductsDTO toDTO(ProductEntity productEntity){
        return ProductsDTO.builder()
                .entity_id(productEntity.getId())
                .title(productEntity.getTitle())
                .category(productEntity.getCategory())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .image(productEntity.getImage())
                .build();
    }

    public List<ProductsDTO> toListDTO(List<ProductEntity> entityList){
        return entityList.stream().map(this::toDTO).toList();
    }
}
