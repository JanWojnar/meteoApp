package com.janwojnar.meteoapp.web.controller.rest;

import com.janwojnar.meteoapp.core.LastWeekRainingsAndDateTimeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class GeoController {

    @Autowired
    private LastWeekRainingsAndDateTimeUseCase lastWeekRainingsAndDateTimeUseCase;

    @GetMapping("/{longitude}/{latitude}")
    public ResponseEntity<Object> getLastWeekRainingsAndDaytime(@PathVariable String longitude, @PathVariable String latitude){
        return lastWeekRainingsAndDateTimeUseCase.getLastWeekRainingsAndDaytime(longitude,latitude);
    }
}
