package com.example.coordinates.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Data
@NoArgsConstructor
public class Coordinate {
    private List<Double> startPos;

    private List<Double> endPos;

    private String startAddress;

    private String endAddress;

    private int distance;

    @Override
    public int hashCode() {
        return Objects.hash(startPos, endPos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(startPos, that.startPos) && Objects.equals(endPos, that.endPos);
    }
}
