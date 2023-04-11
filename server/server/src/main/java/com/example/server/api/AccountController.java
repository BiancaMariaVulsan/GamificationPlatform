package com.example.server.api;

import com.example.server.dto.*;
import com.example.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResultDto = accountService.login(loginRequestDto);

        if (loginResultDto != null) {
            return ResponseEntity.ok(loginResultDto.toLoginResponseDto());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody SignupRequestDto userRegisterRequestDto) {
        boolean registeredWatcher = accountService.signup(userRegisterRequestDto);
        return ResponseEntity.ok(registeredWatcher);
    }
}
