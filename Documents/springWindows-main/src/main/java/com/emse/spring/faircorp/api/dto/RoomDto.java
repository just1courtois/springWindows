package com.emse.spring.faircorp.api.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;
import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private Double current_temperature;
    private Double target_temperature;
    private List<Window> windows;
    private List<Heater> heaters;
    private Long buildingId;


    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.buildingId = room.getBuilding().getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}

