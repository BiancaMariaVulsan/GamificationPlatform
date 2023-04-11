package com.example.server.service;

import com.example.server.dto.UserDto;
import com.example.server.model.User;
import com.example.server.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class UserService<ModelMapper> implements IUserService {

    private final IUserRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(IUserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public java.util.List<UserDto> getUsers() throws ExecutionException, InterruptedException {
        List<User> users = (List<User>) repository.selectAll();
        return users.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
}