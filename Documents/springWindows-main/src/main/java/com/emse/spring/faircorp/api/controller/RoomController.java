package com.emse.spring.faircorp.api.controller;

import com.emse.spring.faircorp.api.dto.HeaterDto;
import com.emse.spring.faircorp.api.dto.RoomDto;
import com.emse.spring.faircorp.api.dto.WindowDto;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    private final RoomDao roomDao;
    private final BuildingDao buildingDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;
    private List<Window> windows;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao, WindowDao windowDao, HeaterDao heaterDao){
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;

    }

    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

/*
    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {
        // WindowDto must always contain the window room
        Building building = buildingDao.getById(dto.getBuildingId());
        Room room = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(), building));
        }
        else {
            room = roomDao.getById(dto.getId());  // (9)
        }
        return new RoomDto(room);
    }
*/

    @GetMapping(path = "/api/rooms/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @DeleteMapping(path = "/api/rooms/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/api/rooms/{room_id}/switchWindowsOn")
    public RoomDto switchWindowsStatusToOpen(@PathVariable Long room_id) {
        List<Window> windows = roomDao.findAllWindows(room_id);
        for (Window window : windows) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.CLOSED? WindowStatus.OPEN: WindowStatus.OPEN);
        }
        return new RoomDto((Room) windows);
    }

    @PutMapping(path = "/api/rooms/{room_id}/switchWindowsOff")
    public RoomDto switchWindowsStatusToCLosed(@PathVariable Long room_id) {
        List<Window> windows = roomDao.findAllWindows(room_id);
        for (Window window : windows) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN? WindowStatus.CLOSED: WindowStatus.CLOSED);
        }
        return new RoomDto((Room) windows);
    }

    @PutMapping(path = "/api/rooms/{room_id}/switchHeaterOn")
    public RoomDto switchHeatersStatusToOn(@PathVariable Long room_id) {
        List<Heater> heaters = roomDao.findAllHeaters(room_id);
        for (Heater heater : heaters) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.OFF ? HeaterStatus.ON: HeaterStatus.ON);
        }
        return new RoomDto((Room) heaters);
    }

    @PutMapping(path = "/rooms/{room_id}/switchHeaterOff")
    public RoomDto switchHeatersStatusToOff(@PathVariable Long room_id) {
        List<Heater> heaters = roomDao.findAllHeaters(room_id);
        for (Heater heater : heaters) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.OFF);
        }
        return new RoomDto((Room) heaters);
    }




}
