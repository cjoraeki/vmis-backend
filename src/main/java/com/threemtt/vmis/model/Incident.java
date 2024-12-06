package com.threemtt.vmis.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.threemtt.vmis.enums.ReportReason;
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
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String location;

    private String plateNumber;

    private String witness;

    private String reporterPhoneNumber;

    @Enumerated(value = EnumType.STRING)
    private ReportReason reportReason;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    @JsonIgnore
    private Officer officer;

}
