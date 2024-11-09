package com.example.coordinates.utils;

import java.util.List;

public class Util {
    private static final double EARTH_RADIUS_M = 6371000.0;

    public static int getDistance(List<Double> startPos, List<Double> endPos) {
        double lat1 = Math.toRadians(startPos.get(0));
        double lon1 = Math.toRadians(startPos.get(1));
        double lat2 = Math.toRadians(endPos.get(0));
        double lon2 = Math.toRadians(endPos.get(1));

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1) *
                Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS_M * b;

        return (int) distance;
    }
}
