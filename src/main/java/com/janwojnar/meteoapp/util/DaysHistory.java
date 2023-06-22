package com.janwojnar.meteoapp.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DaysHistory {
    private List<DayHistory> last_seven_days;
}
