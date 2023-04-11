package com.example.server.api;

import com.example.server.dto.UserBadgesResponseDto;
import com.example.server.model.Badge;
import com.example.server.service.IBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgesController {

    private final IBadgeService badgeService;

    @Autowired
    public BadgesController(IBadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserBadgesResponseDto> getUserBadges(@PathVariable int userId) {
        UserBadgesResponseDto result = badgeService.getUserBadges(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/owned/{userId}")
    public ResponseEntity<List<Badge>> getUserOwnedBadges(@PathVariable int userId) {
        List<Badge> result = badgeService.getUserOwnedBadges(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/proposed/{userId}")
    public ResponseEntity<List<Badge>> getUserProposedBadges(@PathVariable int userId) {
        List<Badge> result = badgeService.getUserProposedBadges(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/in-progress/{userId}")
    public ResponseEntity<List<Badge>> getUserInProgressBadges(@PathVariable int userId) {
        List<Badge> result = badgeService.getUserInProgressBadges(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity createBadge(@RequestBody Badge badge) {
        badgeService.createBadge(badge);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/assign")
    public ResponseEntity assignBadge(@RequestBody Badge badge) {
        badgeService.assignBadge(badge);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/challenges/{userId}")
    public ResponseEntity<List<Badge>> getChallenges(@PathVariable int userId) {
        List<Badge> challenges = badgeService.getUserChallenges(userId);
        return ResponseEntity.ok(challenges);
    }
}
