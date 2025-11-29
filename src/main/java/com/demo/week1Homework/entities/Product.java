package com.demo.week1Homework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "product_table",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "title_price_unique",
                        columnNames = {"title_s", "price"}
                )
        },
        indexes = {
                @Index(name = "sku_index", columnList = "sku")
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String sku;

    @Column(name = "title_s")
    private String title;

    private BigDecimal price;

    private int quantity;

    private boolean active;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
