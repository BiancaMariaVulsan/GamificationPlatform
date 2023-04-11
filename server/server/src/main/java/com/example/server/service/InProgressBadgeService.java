package com.example.server.service;

import com.example.server.model.Badge;
import com.example.server.model.InProgressBadge;
import com.example.server.repo.GenericRepository;
import com.example.server.repo.IInProgressBadgeRepository;

import javax.naming.Context;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class InProgressBadgeRepository extends GenericRepository<InProgressBadge> implements IInProgressBadgeRepository {
    public InProgressBadgeRepository(AppDbContext context) {
        super(context);
    }

    @Override
    public CompletableFuture<List<Badge>> getInProgressBadges(int userId) {
        return CompletableFuture.supplyAsync(() ->
                Context.getInProgressBadge()
                        .where(b -> b.getUserId() == userId)
                        .include(b -> b.getBadge())
                        .select(b -> b.getBadge())
                        .ToListAsync()
        );
    }

    @Override
    public CompletableFuture<List<Badge>> getStartedChallengesByUser(int userId) {
        return CompletableFuture.supplyAsync(() ->
                Context.getInProgressBadge()
                        .where(b -> b.getUserId() == userId)
                        .include(b -> b.getBadge())
                        .select(b -> b.getBadge())
                        .ToListAsync()
        );
    }
}