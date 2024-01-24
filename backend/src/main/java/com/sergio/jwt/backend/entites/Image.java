package com.sergio.jwt.backend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.BlobJdbcType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Base64;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "image", schema = "spring_security")
public class Image {
    @Id
    @Column(name = "id", nullable = false )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    @Lob
    @Column(name = "data", nullable = false, columnDefinition="MEDIUMBLOB")
    private byte[] data;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @CreatedDate
    private LocalDateTime createdDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
    public String generateBase64Image()
    {
       return  Base64.getEncoder().encodeToString(this.getData());

    }

    public Image(int id, String fileName, String contentType, byte[] bytes, Product p) {
        this.id = id;
        this.name =  fileName;
        this.data = bytes;
        this.type = contentType;
        this.product = p;
    }
}