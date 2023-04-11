package com.example.server.repo;

import com.example.server.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IUserRepository extends IGenericRepository<User> {
    CompletableFuture<User> login(String username, String password);

    CompletableFuture<Void> signup(User user);

    CompletableFuture<Boolean> userExists(String email);

    CompletableFuture<List<User>> getLeaderboard(int topCount, int userId);
}
