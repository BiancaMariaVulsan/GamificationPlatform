package com.example.server.dto;

import com.example.server.model.Badge;

import java.util.List;

public class UserBadgesResponseDto {
    public List<Badge> proposedBadges;
    public List<Badge> ownedBadges;
    public List<Badge> inProgressBadges;

    public UserBadgesResponseDto(List<Badge> userProposedBadges, List<Badge> userOwnedBadges, List<Badge> userInProgressBadges) {
        this.proposedBadges = userProposedBadges;
        this.ownedBadges = userOwnedBadges;
        this.inProgressBadges = userInProgressBadges;
    }
}
