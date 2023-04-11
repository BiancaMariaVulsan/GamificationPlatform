package com.example.server.service;

import com.example.server.dto.LeaderboardRequestDto;
import com.example.server.dto.LeaderboardResponseDto;

public interface ILeaderboardService {
    LeaderboardResponseDto leaderBoard(LeaderboardRequestDto request);

}
