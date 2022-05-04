package com.example.hockeyprojectbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Builder;
import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Player model class from JPA
 *
 * @Entity creater tabel in mySQL
 * @auth Christoffer
 */
@Entity
public class Player {    //Christoffer 12:00

    /**
     * Creates autoincremented ID for our column player_id
     *
     * @Id = PrimaryKey
     * @Column = name for specific column
     * @GeneratedValue = Autoincremented value
     * @auth Christoffer
     */
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isSelected;

    /**
     * Joining player with position class
     *
     * @OneToOne makes relationship between 1 column, CascadeType on both classes so we can add a player to a position
     * and a position to a player
     * @JoinColumn Joining column of other table
     * @auth Christoffer
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
