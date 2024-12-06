package com.threemtt.vmis.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private String badgeNumber;

    private String phoneNumber;

    private String governmentAgency;
}
