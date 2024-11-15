package com.example.coordinates.service;

import com.example.coordinates.model.Coordinate;

import java.util.List;

public interface CoordinateService {
    Coordinate getAddressAndDistance(Coordinate coordinate);

    String getAddress(List<Double> pos);
}
