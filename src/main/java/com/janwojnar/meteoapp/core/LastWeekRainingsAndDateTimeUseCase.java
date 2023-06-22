package com.janwojnar.meteoapp.core;

import com.janwojnar.meteoapp.domain.service.EndpointCallService;
import com.janwojnar.meteoapp.domain.to.EndpointCallTo;
import com.janwojnar.meteoapp.util.DayHistory;
import com.janwojnar.meteoapp.util.DaysHistory;
import com.janwojnar.meteoapp.validator.GeoControllerValidator;
import com.janwojnar.meteoapp.web.service.OpenMeteoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class LastWeekRainingsAndDateTimeUseCase {

    @Autowired
    private OpenMeteoApiService openMeteoApiService;

    @Autowired
    private EndpointCallService endpointCallService;

    @Autowired
    private GeoControllerValidator geoControllerValidator;

    //todo parsowanie do day i ładny zwrot

    public ResponseEntity<Object> getLastWeekRainingsAndDaytime(@PathVariable String longitude, @PathVariable String latitude) {

        ResponseEntity<Object> response = null;

        EndpointCallTo endpointCallTo = EndpointCallTo.builder()
                .longitude(longitude)
                .latitude(latitude)
                .timeOfCall(LocalDateTime.now())
                .build();

        endpointCallService.save(endpointCallTo);

        if(!geoControllerValidator.validateGetLastWeekRainingsAndDaytimeInput(longitude,latitude)){
            response = ResponseEntity.badRequest().body("Provided coordinates do not match WGS84 format");
        }

        if (Objects.isNull(response)) {
            DaysHistory responseBody = openMeteoApiService.getLastWeekRainingsAndDaytime(longitude,latitude);
            response = ResponseEntity.ok(responseBody);
        }

        return response;
    }
}