package com.example.server.repo;

import com.example.server.model.Badge;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IBadgeRepository extends IGenericRepository<Badge> {
    CompletableFuture<List<Badge>> getUserProposedBadges(int userId);
    CompletableFuture<List<Badge>> getUserOwnedBadges(int userId);
    CompletableFuture<List<Badge>> getUserChallenges(int userId);
}