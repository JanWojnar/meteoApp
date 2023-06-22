package com.janwojnar.meteoapp.web.service;

import com.janwojnar.meteoapp.util.DaysHistory;
import com.janwojnar.meteoapp.util.DaysHistoryParser;
import com.janwojnar.meteoapp.util.OpenMeteoApiResponse;
import com.janwojnar.meteoapp.web.adapter.OpenMeteoApiAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class OpenMeteoApiService {

    @Autowired
    OpenMeteoApiAdapter openMeteoApiAdapter;

    public DaysHistory getLastWeekRainingsAndDaytime(String longitude, String latitude){
        OpenMeteoApiResponse apiResponse = openMeteoApiAdapter.getLastWeekRainingsAndDaytime(longitude,latitude, getXDaysAgoDate(7L), getXDaysAgoDate(1L));
        log.info("Response with days provided.");
        return DaysHistoryParser.parse(apiResponse);
    }

    private LocalDate getXDaysAgoDate(long minusDays){
        long epochDay = LocalDate.now().toEpochDay();
        return LocalDate.ofEpochDay(epochDay - minusDays);
    }
}
