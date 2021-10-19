package com.emse.spring.faircorp.api.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/hello")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;


    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }
}
