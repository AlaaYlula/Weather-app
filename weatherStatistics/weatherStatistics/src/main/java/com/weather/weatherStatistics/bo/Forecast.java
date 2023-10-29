package com.weather.weatherStatistics.bo;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forecast {

    public ArrayList<Forecastday> forecastday;

}
