//package com.threemtt.vmis.model;
//
//import com.threemtt.vmis.enums.Role;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@MappedSuperclass
//@Getter
//@Setter
//public class User implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String firstname;
//
//    private String lastname;
//
//    private String governmentAgency;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false, unique = true)
//    private String phoneNumber;
//
//    @Column(nullable = false, unique = true) //Officer ID
//    private String badgeNumber;
//
//    @Enumerated(value = EnumType.STRING)
//    private Role role;
//
//    @CreationTimestamp
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
//}
