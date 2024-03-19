package com.CarRental.Service.Services.auth;

import com.CarRental.dto.SignupRequest;
import com.CarRental.dto.UserDto;

public interface AuthService    {

    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}