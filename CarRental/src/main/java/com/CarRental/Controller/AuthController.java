package com.CarRental.Controller;

import com.CarRental.Service.Services.auth.AuthService;
import com.CarRental.dto.SignupRequest;
import com.CarRental.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest){
        if (authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already present", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdCustomerDTo =authService.createCustomer(signupRequest);
        if(createdCustomerDTo==null) return new ResponseEntity<>("Customer Not Created , Come Back Later",
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDTo, HttpStatus.CREATED);
    }
}
