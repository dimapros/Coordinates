package com.example.coordinates.controllers;

import com.example.coordinates.entity.Coordinate;
import com.example.coordinates.services.CoordinateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoordinateController {
    CoordinateService coordinateService;

    public CoordinateController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @GetMapping("/addressAndDistance")
    public Coordinate getAddressAndDistance(@RequestBody Coordinate coordinate) {
        return coordinateService.getAddressAndDistance(coordinate);
    }
}