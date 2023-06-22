package com.janwojnar.meteoapp.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DayHistory {

    private LocalDate time;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private Double rain_sum;

}
