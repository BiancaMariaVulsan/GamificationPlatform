package com.example.server.service;

import com.example.server.dto.LeaderboardRequestDto;
import com.example.server.dto.LeaderboardResponseDto;
import com.example.server.repo.IUserRepository;

public class LeaderboardService implements ILeaderboardService {

    private final IUserRepository _userRepository;

    public LeaderboardService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public LeaderboardResponseDto leaderBoard(LeaderboardRequestDto request) {
        var result = _userRepository.getLeaderboard(request.getTopCount(), request.getUserId());
        var response = new LeaderboardResponseDto(result.getUsers(), result.getRank());
        return response;
    }
}
