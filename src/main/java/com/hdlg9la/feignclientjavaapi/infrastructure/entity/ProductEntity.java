package com.hdlg9la.feignclientjavaapi.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {

    @Id
    @Column
    private String id;
    @Column(name = "title", length = 800)
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category", length = 800)
    private String category;
    @Column(name = "description", length = 800)
    private String description;
    @Column(name = "image", length = 800)
    private String image;
    @Column(name = "inclusion_date")
    private LocalDateTime inclusionDate;
}
