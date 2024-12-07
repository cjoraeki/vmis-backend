package com.threemtt.vmis.service;


import com.threemtt.vmis.dto.request.AdminDto;
import com.threemtt.vmis.dto.request.OfficerDto;
import com.threemtt.vmis.dto.request.UserRequest;
import com.threemtt.vmis.dto.response.UserResponse;
import com.threemtt.vmis.enums.Role;
import com.threemtt.vmis.model.Admin;
import com.threemtt.vmis.model.Officer;
import com.threemtt.vmis.repository.AdminRepository;
import com.threemtt.vmis.repository.OfficerRepository;
import com.threemtt.vmis.utilities.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final AdminRepository adminRepository;
    private final OfficerRepository officerRepository;
    private final Utils utils;
    private static String AVAILABLE;
    private static String UNAVAILABLE;


    @Override
    public UserResponse registerAdmin(UserRequest userRequest) throws Exception {
        if (adminRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new Exception("Admin already exists. Go to Login");
        }

        Admin admin = new Admin();
        admin.setFirstname(userRequest.getFirstname());
        admin.setLastname(userRequest.getLastname());
        admin.setEmail(userRequest.getEmail());
        admin.setPassword(userRequest.getPassword());
        admin.setPhoneNumber(userRequest.getPhoneNumber());
        admin.setGovernmentAgency(userRequest.getGovernmentAgency());

        admin.setBadgeNumber(utils.generateString());
        admin.setRole(Role.ADMIN);

        adminRepository.save(admin);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(admin, userResponse);

        return userResponse;
    }

    @Override
    public UserResponse registerOfficer(UserRequest userRequest) throws Exception {
        if (officerRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new Exception("Officer already exists. Go to Login");
        }

        Officer officer = new Officer();
        officer.setFirstname(userRequest.getFirstname());
        officer.setLastname(userRequest.getLastname());
        officer.setEmail(userRequest.getEmail());
        officer.setPassword(userRequest.getPassword());
        officer.setPhoneNumber(userRequest.getPhoneNumber());
        officer.setGovernmentAgency(userRequest.getGovernmentAgency());
        officer.setAvailabilityStatus(AVAILABLE);

        officer.setBadgeNumber(utils.generateString());
        officer.setRole(Role.OFFICER);

        officerRepository.save(officer);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(officer, userResponse);

        return userResponse;
    }

    @Override
    public String deleteOfficer(String badgeNumber) throws Exception{
        Optional<Officer> user = officerRepository.deleteByBadgeNumber(badgeNumber);
        if (user.isEmpty()){
            throw new Exception("Badge number "+badgeNumber+" does not exist.");
        }
        return "Officer "+badgeNumber+" deleted successfully";
    }

    @Override
    public UserResponse updateOfficer(UserRequest userRequest) throws Exception {
        Optional<Officer> userOptional = officerRepository.findByPhoneNumber(userRequest.getPhoneNumber());

        if (userOptional.isEmpty()) {
            throw new Exception("Officer with phone number: " + userRequest.getPhoneNumber() + " does not exist");
        }

        Officer existingUser = userOptional.get();

        existingUser.setFirstname(userRequest.getFirstname());
        existingUser.setLastname(userRequest.getLastname());
        existingUser.setPassword(userRequest.getPassword());
        existingUser.setPhoneNumber(userRequest.getPhoneNumber());
        existingUser.setRole(Role.OFFICER);

        Officer updatedUser = officerRepository.save(existingUser);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(updatedUser, userResponse);

        return userResponse;
    }

    @Override
    public String officerLogin(OfficerDto officerDto) {
        Optional<Officer> officer = officerRepository.findByBadgeNumber(officerDto.getBadgeNumber());

        if (officer.isEmpty()) {
            throw new RuntimeException("Officer not found");
        }

        if (!(officer.get().getBadgeNumber().equals(officerDto.getBadgeNumber()) )){
            System.out.println(officer.get().getBadgeNumber());
            throw new RuntimeException("Invalid Badge number");
        }

        if (!(officer.get().getPassword().equals(officerDto.getPassword()) )){
            System.out.println(officer.get().getBadgeNumber());
            throw new RuntimeException("Invalid password");
        }

        return officerDto.getBadgeNumber()+ " login successful.";
    }

    @Override
    public String adminLogin(AdminDto adminDto) {
        Optional<Admin> admin = adminRepository.findByBadgeNumber(adminDto.getBadgeNumber());

        if (admin.isEmpty()) {
            throw new RuntimeException("Officer not found");
        }
        if (!(admin.get().getBadgeNumber().equals(adminDto.getBadgeNumber()) )){
            System.out.println(admin.get().getBadgeNumber());
            throw new RuntimeException("Invalid Badge number");
        }
        return adminDto.getBadgeNumber()+ " login successful.";
    }

    @Override
    public Optional<Officer> findOfficer(String badgeNumber){
        return officerRepository.findByBadgeNumber(badgeNumber);
    }
}
