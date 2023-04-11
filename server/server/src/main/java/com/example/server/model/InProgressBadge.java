package com.example.server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "InProgressBadges")
public class InProgressBadge extends ModelBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    
    @Column(name = "UserId")
    private int UserId;
    
    @ManyToOne
    @JoinColumn(name = "BadgeId", foreignKey = @ForeignKey(name = "FK_InProgressBadge_Badge"))
    private Badge Badge;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Badge getBadge() {
        return Badge;
    }

    public void setBadge(Badge badge) {
        Badge = badge;
    }
}
