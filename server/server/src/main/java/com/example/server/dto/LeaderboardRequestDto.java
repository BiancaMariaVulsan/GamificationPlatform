package com.example.server.dto;

import javax.validation.constraints.NotNull;

public class LeaderboardRequestDto {
    @NotNull
    private Integer userId;

    @NotNull
    private Integer topCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopCount() {
        return topCount;
    }

    public void setTopCount(Integer topCount) {
        this.topCount = topCount;
    }
}
