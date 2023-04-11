package com.example.server.service;

import com.example.server.dto.LoginRequestDto;
import com.example.server.dto.LoginResponseDto;
import com.example.server.dto.SignupRequestDto;

public interface IAccountService {
    public LoginResponseDto login(LoginRequestDto loginRequestDto);
    public Boolean signup(SignupRequestDto signupRequestDto);
}
