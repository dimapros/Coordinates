package com.example.coordinates.service;

import com.example.coordinates.model.Coordinate;
import com.example.coordinates.model.NominatimResponse;
import com.example.coordinates.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateServiceImpl implements CoordinateService{
    private final RestTemplate restTemplate;
    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org";

    public CoordinateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Coordinate getAddressAndDistance(Coordinate coordinate) {
        coordinate.setStartAddress(getAddress(coordinate.getStartPos()));
        coordinate.setEndAddress(getAddress(coordinate.getEndPos()));
        coordinate.setDistance(Util.getDistance(coordinate.getStartPos(), coordinate.getEndPos()));

        return coordinate;
    }

    public String getAddress(List<Double> pos) {
        String url = NOMINATIM_URL + "/reverse?lat=" +
                pos.get(0) + "&lon=" + pos.get(1) + "&format=json";
        Optional<NominatimResponse> forObject = Optional.ofNullable(restTemplate.getForObject(url, NominatimResponse.class));

        return forObject.map(NominatimResponse::getAddress).orElse("Unknown address");
    }
}
