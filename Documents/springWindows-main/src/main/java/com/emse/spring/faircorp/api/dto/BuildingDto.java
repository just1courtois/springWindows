package com.emse.spring.faircorp.api.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

public class BuildingDto {
    private Long id;
    private String name;
    private Set<Room> rooms;

    public BuildingDto(){
    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = building.getRooms();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
