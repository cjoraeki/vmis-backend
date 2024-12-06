package com.threemtt.vmis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carModel;

    @Column(nullable = false, unique = true)
    private String plateNumber;

    private String carOwner;

    @Column(nullable = false, unique = true)
    private String nin;

    @Column(nullable = false, unique = true)
    private String driversLicense;

    private String description;

    @Column(nullable = false, unique = true)
    private String engineNumber;

    private Integer yearOfManufacture;

    private String color;

    private Boolean flagged;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
