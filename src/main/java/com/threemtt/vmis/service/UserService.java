package com.threemtt.vmis.service;

import com.threemtt.vmis.dto.request.AdminDto;
import com.threemtt.vmis.dto.request.LoginDto;
import com.threemtt.vmis.dto.request.UserRequest;
import com.threemtt.vmis.dto.response.UserResponse;
import com.threemtt.vmis.model.Officer;

import java.util.Optional;


public interface UserService {

    UserResponse registerAdmin(UserRequest userRequest) throws Exception;
    UserResponse registerOfficer(UserRequest userRequest) throws Exception;
    String deleteOfficer(String badgeNumber) throws Exception;
    UserResponse updateOfficer(UserRequest userRequest) throws Exception;

    String officerLogin(LoginDto loginDto);

    String adminLogin(AdminDto adminDto);

    Optional<Officer> findOfficer(String badgeNumber);
}
