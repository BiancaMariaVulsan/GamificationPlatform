package com.example.server.repo;

import com.example.server.model.User;

import javax.naming.Context;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UserRepository extends GenericRepository<User> {

    public UserRepository(AppDbContext context) {
        super(context);
    }

    public CompletableFuture<User> loginAsync(String username, String password) {
        return Context.getUser()
                .filter(w -> w.getUsername().equals(username) &&
                        w.getPassword().equals(password))
                .findFirst()
                .map(CompletableFuture::completedFuture)
                .orElseGet(() -> CompletableFuture.completedFuture(null));
    }

    public CompletableFuture<Void> signupAsync(User user) {
        return insertAsync(user);
    }

    public CompletableFuture<Boolean> userExistsAsync(String email) {
        return Context.getUser().stream()
                .anyMatch(u -> u.getEmail().equals(email)) ?
                CompletableFuture.completedFuture(true) :
                CompletableFuture.completedFuture(false);
    }

    public CompletableFuture<List<User>> getLeaderboardAsync(int topCount, int userId) {
        return Context.getUser().stream()
                .sorted((u1, u2) -> u2.getPoints() - u1.getPoints())
                .limit(topCount)
                .toList()
                .thenApply(users -> {
                    User user = Context.getUser().stream()
                            .filter(u -> u.getId() == userId)
                            .findFirst()
                            .orElse(null);

                    int rank = (int)Context.getUser().stream()
                            .filter(u -> u.getPoints() > user.getPoints())
                            .count() + 1;

                    return List.of(users, rank);
                });
    }
}
