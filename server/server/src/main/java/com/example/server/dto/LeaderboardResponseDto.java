package com.example.server.dto;

import com.example.server.model.User;
import java.util.List;

public class LeaderboardResponseDto {
    private List<User> users;
    private int rank;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
