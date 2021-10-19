package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity// (1)
@Table(name = "ROOM")// (2)
public class Room {
    @Id // (3).
    @GeneratedValue

    private Long id;

    @Column(nullable = false, length = 255)// (4)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = true)
    private Double current_temperature;

    @Column(nullable = true)
    private Double target_temperature;

    @OneToMany(mappedBy = "room")  //Parent of Heater
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    @ManyToOne //child of Building
    private Building building ;//define building



    public Room() {
    }

    public Room(String name, int floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloor() {
        return floor;
    }

    public double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }
}