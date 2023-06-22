package com.janwojnar.meteoapp.web.controller.rest;

import com.janwojnar.meteoapp.core.LastWeekRainingsAndDateTimeUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Slf4j
public class GeoController {

    @Autowired
    private LastWeekRainingsAndDateTimeUseCase lastWeekRainingsAndDateTimeUseCase;

    @GetMapping("/{longitude}/{latitude}")
    public ResponseEntity<Object> getLastWeekRainingsAndDaytime(@PathVariable String longitude, @PathVariable String latitude){

        log.info("Incoming call on rest method 'getLastWeekRainingsAndDaytime' with params: longitude: " + longitude
                + " and latitude: " +latitude);

        return lastWeekRainingsAndDateTimeUseCase.getLastWeekRainingsAndDaytime(longitude,latitude);
    }
}
