package com.threemtt.vmis.controller;

import com.threemtt.vmis.dto.request.AdminDto;
import com.threemtt.vmis.dto.request.OfficerDto;
import com.threemtt.vmis.dto.request.UserRequest;
import com.threemtt.vmis.dto.response.UserResponse;
import com.threemtt.vmis.model.Officer;
import com.threemtt.vmis.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerAdmin(@Valid @RequestBody UserRequest userRequest) throws Exception {
        return new ResponseEntity<>(userService.registerAdmin(userRequest), HttpStatus.CREATED);
    }

    @PostMapping("/register/officer")
    public ResponseEntity<UserResponse> registerOfficer(@Valid @RequestBody UserRequest userRequest) throws Exception {
        return new ResponseEntity<>(userService.registerOfficer(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/officer/{badgeNumber}")
    public ResponseEntity<String> deleteOfficerByBadgeNumber(@Valid @PathVariable String badgeNumber) throws Exception {
        return new ResponseEntity<>(userService.deleteOfficer(badgeNumber), HttpStatus.CREATED);
    }

    @GetMapping("find/officer/{badgeNumber}")
    public ResponseEntity<Optional<Officer>> findOfficerByBadgeNumber(@Valid @PathVariable String badgeNumber) throws Exception {
        return new ResponseEntity<>(userService.findOfficer(badgeNumber), HttpStatus.CREATED);
    }

    @PutMapping("/update-officer")
    public ResponseEntity<?> updateOfficer(@RequestBody UserRequest userRequest) {
        try {
            UserResponse updatedUser = userService.updateOfficer(userRequest);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody AdminDto adminDto) {
        try {
            String response = userService.adminLogin(adminDto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login/officer")
    public ResponseEntity<String> adminLogin(@RequestBody OfficerDto officerDto) {
        try {
            String response = userService.officerLogin(officerDto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
