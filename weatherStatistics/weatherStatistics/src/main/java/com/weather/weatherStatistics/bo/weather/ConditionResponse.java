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
public class ConditionResponse {
    public String text;
}
