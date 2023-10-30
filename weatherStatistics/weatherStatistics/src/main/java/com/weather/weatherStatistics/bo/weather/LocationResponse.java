package com.weather.weatherStatistics.bo.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class LocationResponse {
    public String name;
    public String region;
    public String country;
    public String localtime;

}
