package com.example.server.api;

import com.example.server.dto.LeaderboardRequestDto;
import com.example.server.dto.LeaderboardResponseDto;
import com.example.server.service.ILeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final ILeaderboardService service;

    @Autowired
    public LeaderboardController(ILeaderboardService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<LeaderboardResponseDto> getLeaderboard(@RequestBody LeaderboardRequestDto request) throws ExecutionException, InterruptedException {
        LeaderboardResponseDto result = service.leaderBoard(request);
        return ResponseEntity.ok(result);
    }
}
