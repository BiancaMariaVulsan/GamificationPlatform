package com.example.server.repo;

import com.example.server.model.Badge;
import com.example.server.model.InProgressBadge;

import java.util.List;
import java.util.concurrent.CompletableFuture;
public interface IInProgressBadgeRepository extends IGenericRepository<InProgressBadge> {
        CompletableFuture<List<Badge>> getInProgressBadges(int userId);
        CompletableFuture<List<Badge>> getStartedChallengesByUser(int userId);
    }
}
