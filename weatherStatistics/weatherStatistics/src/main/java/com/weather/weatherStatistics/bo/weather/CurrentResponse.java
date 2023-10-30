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

public class CurrentResponse {
    public String last_updated;
    public double temp_c;
    public double temp_f;
    public ConditionResponse condition;

}
