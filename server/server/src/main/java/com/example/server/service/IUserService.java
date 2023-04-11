package com.example.server.service;

import com.example.server.dto.UserDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUserService {
    List<UserDto> getUsers() throws ExecutionException, InterruptedException;
}
