package com.example.server.repo;

import com.example.server.model.Badge;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BadgeRepository implements IBadgeRepository {
    private final AppDbContext context;

    public BadgeRepository(AppDbContext context) {
        this.context = context;
    }

    @Override
    public CompletableFuture<Badge> getById(int id) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao().getById(id));
    }

    @Override
    public CompletableFuture<List<Badge>> getAll() {
        return CompletableFuture.supplyAsync(context.getBadgeDao()::getAll);
    }

    @Override
    public CompletableFuture<Badge> insert(Badge entity) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao().add(entity));
    }

    @Override
    public CompletableFuture<Badge> update(Badge entity) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao().update(entity));
    }

    @Override
    public CompletableFuture<Void> delete(Badge entity) {
        return CompletableFuture.runAsync(() -> context.getBadgeDao().delete(entity));
    }

    @Override
    public CompletableFuture<List<Badge>> getUserProposedBadges(int userId) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao()
                .getByCreatorId(userId));
    }

    @Override
    public CompletableFuture<List<Badge>> getUserOwnedBadges(int userId) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao()
                .getBySolverId(userId));
    }

    @Override
    public CompletableFuture<List<Badge>> getUserChallenges(int userId) {
        return CompletableFuture.supplyAsync(() -> context.getBadgeDao()
                .getUnsolvedChallenges(userId));
    }
}