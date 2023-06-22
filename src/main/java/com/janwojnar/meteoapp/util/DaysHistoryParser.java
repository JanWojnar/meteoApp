package com.janwojnar.meteoapp.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaysHistoryParser {

    public static DaysHistory parse (OpenMeteoApiResponse response){

        int numberOfDays = response.getDaily().getTime().size();

        List<DayHistory> days = new ArrayList<>();
        for(int i = 0 ; i < numberOfDays; i++ ){

            String timeStr = response.getDaily().getTime().get(i);
            LocalDate time = Objects.isNull(timeStr) ? null : LocalDate.parse(timeStr);

            String sunriseStr = response.getDaily().getSunrise().get(i);
            LocalDateTime sunrise = Objects.isNull(sunriseStr) ? null : LocalDateTime.parse(sunriseStr);

            String sunsetStr = response.getDaily().getSunset().get(i);
            LocalDateTime sunset = Objects.isNull(sunsetStr) ? null : LocalDateTime.parse(sunsetStr);

            String rain_sumStr = response.getDaily().getRain_sum().get(i);
            Double rain_sum = Objects.isNull(rain_sumStr) ? null : Double.parseDouble(rain_sumStr);

            days.add(new DayHistory(time,sunrise,sunset,rain_sum));
        }
        return new DaysHistory(days);
    }
}
