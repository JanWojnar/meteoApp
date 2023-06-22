package com.janwojnar.meteoapp.validator;

import org.springframework.stereotype.Component;

@Component
public class GeoControllerValidator {

    private final String longitudeRegexp = "^-?((\\d|[1-9]\\d|1[0-7]\\d)\\.\\d{2}|180(\\.00)?)$";

    private final String latitudeRegexp = "^-?((\\d|[1-8]\\d)\\.\\d{2}|90(\\.00)?)$";

    public boolean validateGetLastWeekRainingsAndDaytimeInput(String longitude, String latitude){
        return longitude.matches(longitudeRegexp) && latitude.matches(latitudeRegexp);
    }
}
