package com.sergio.jwt.backend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product", schema = "spring_security")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;

    @Size(max = 255)
    @Column(name = "product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Category cate;

    @OneToMany(mappedBy = "product")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ProdTag> prodTags = new LinkedHashSet<>();

}