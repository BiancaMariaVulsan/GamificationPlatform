package com.example.server.service;

import com.example.server.dto.UserBadgesResponseDto;
import com.example.server.model.Badge;
import com.example.server.repo.GenericRepository;
import com.example.server.repo.IBadgeRepository;

import java.util.ArrayList;
import java.util.List;

public class BadgeService implements IBadgeService {

    private final IBadgeRepository badgeRepository;
    private final GenericRepository.IInProgressBadgeRepository inProgressBadgeRepository;

    public BadgeService(IBadgeRepository badgeRepository, GenericRepository.IInProgressBadgeRepository inProgressBadgeRepository) {
        this.badgeRepository = badgeRepository;
        this.inProgressBadgeRepository = inProgressBadgeRepository;
    }

    @Override
    public UserBadgesResponseDto getUserBadges(int userId) {
        return new UserBadgesResponseDto(
                getUserProposedBadges(userId),
                getUserOwnedBadges(userId),
                getUserInProgressBadges(userId)
        );
    }

    @Override
    public List<Badge> getUserProposedBadges(int userId) {
        return (List<Badge>) badgeRepository.getUserProposedBadges(userId);
    }

    @Override
    public List<Badge> getUserOwnedBadges(int userId) {
        return (List<Badge>) badgeRepository.getUserOwnedBadges(userId);
    }

    @Override
    public List<Badge> getUserInProgressBadges(int userId) {
        return (List<Badge>) inProgressBadgeRepository.getInProgressBadges(userId);
    }

    @Override
    public void createBadge(Badge badge) {
        badgeRepository.insert(badge);
    }

    @Override
    public void assignBadge(Badge badge) {
        badgeRepository.update(badge);
    }

    @Override
    public List<Badge> getUserChallenges(int userId) {
        List<Badge> initialChallenges = (List<Badge>) badgeRepository.getUserChallenges(userId);
        List<Badge> inProgressChallenges = (List<Badge>) inProgressBadgeRepository.getStartedChallengesByUser(userId);
        var badges = new ArrayList<Badge>();

        for (Badge challenge : initialChallenges) {
            var exists = inProgressChallenges.stream().anyMatch(c -> c.getId() == challenge.getId());

            if (!exists)
                badges.add(challenge);
        }

        return badges;
    }
}
