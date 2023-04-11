package com.example.server.service;

import com.example.server.dto.UserBadgesResponseDto;
import com.example.server.model.Badge;

import java.util.List;

public interface IBadgeService {
    UserBadgesResponseDto getUserBadges(int userId);

    List<Badge> getUserProposedBadges(int userId);

    List<Badge> getUserOwnedBadges(int userId);

    List<Badge> getUserInProgressBadges(int userId);

    void createBadge(Badge badge);

    void assignBadge(Badge badge);

    List<Badge> getUserChallenges(int userId);
}
