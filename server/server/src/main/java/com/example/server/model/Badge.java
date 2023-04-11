package com.example.server.model;

import java.util.Random;

public class Badge extends ModelBase {
    public String Title;
    public String Description;
    public int Points;
    public int CreatorId;
    public User Creator;
    public Integer SolverId;
    public User Solver;

    public Badge() {}
    public Badge(int id, String title, String description, int points) {
        Random rand = new Random();
        int creatorId = rand.nextInt(14) + 1;
        int solverId = rand.nextInt(99) + 1;
        Id = id;
        Title = title;
        Description = description;
        Points = points;
        CreatorId = creatorId;
        SolverId = solverId > 75 ? solverId : null;
    }
}
