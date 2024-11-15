package com.example.coordinates.controller;

import com.example.coordinates.model.Coordinate;
import com.example.coordinates.service.CoordinateService;
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