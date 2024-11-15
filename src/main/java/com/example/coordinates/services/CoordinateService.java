package com.example.coordinates.services;

import com.example.coordinates.entity.Coordinate;

import java.util.List;

public interface CoordinateService {
    Coordinate getAddressAndDistance(Coordinate coordinate);

    String getAddress(List<Double> pos);
}
