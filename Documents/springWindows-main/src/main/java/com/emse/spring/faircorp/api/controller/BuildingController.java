package com.emse.spring.faircorp.api.controller;

import com.emse.spring.faircorp.api.dto.BuildingDto;
import com.emse.spring.faircorp.api.dto.RoomDto;
import com.emse.spring.faircorp.api.dto.WindowDto;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;


    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping // (5)
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/api/buildings/{building_id}")
    public BuildingDto findById(@PathVariable Long building_id) {
        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null); // (7)
    }

    @PostMapping // (8)
    public BuildingDto create(@RequestBody BuildingDto dto) {
        // On creation id is not defined
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {
            building = buildingDao.getById(dto.getId());  // (9)
        }
        return new BuildingDto(building);
    }

    @DeleteMapping(path = "api/buildings/{building_id}")
    public void delete(@PathVariable Long id) {

        buildingDao.deleteById(id);
    }


}
