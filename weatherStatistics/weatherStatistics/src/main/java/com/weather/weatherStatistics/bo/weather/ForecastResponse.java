package com.weather.weatherStatistics.bo.weather;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForecastResponse {

    public ArrayList<ForecastdayResponse> forecastday;

}
