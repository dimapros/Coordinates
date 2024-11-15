package com.example.coordinates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class NominatimResponse {
    @JsonProperty("display_name")
    private String address;
}
