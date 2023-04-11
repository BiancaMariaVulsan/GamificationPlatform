package com.example.server.service;

import com.example.server.dto.LoginRequestDto;
import com.example.server.dto.LoginResponseDto;
import com.example.server.dto.SignupRequestDto;
import com.example.server.repo.IUserRepository;

public class AccountService implements IAccountService {
    private final IUserRepository userRepository;
    private final IMapper mapper;

    public AccountService(IUserRepository userRepository, IMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        var user = userRepository.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        if (user == null) {
            return null;
        }

        return mapper.Map<User, LoginResponseDto>(user);
    }

    @Override
    public Boolean signup(SignupRequestDto signupRequestDto) {
        if (userRepository.userExists(signupRequestDto.getEmail())) {
            return false;
        }

        var user = mapper.Map<User>(signupRequestDto);
        user.setPoints(0);
        userRepository.insert(user);

        return true;
    }
}
