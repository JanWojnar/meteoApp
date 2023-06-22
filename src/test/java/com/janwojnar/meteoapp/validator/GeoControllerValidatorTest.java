package com.janwojnar.meteoapp.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoControllerValidatorTest {
    private final GeoControllerValidator validator = new GeoControllerValidator();
    @Test
    void validateGetLastWeekRainingsAndDaytimeInput() {

        Assertions.assertAll(
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("-180.00","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("-179.99","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("179.99","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("180.00","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","-90.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","-89.99")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","0.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","89.99")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","90.00")),
                () -> Assertions.assertTrue(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","90.00")),

                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","90.0")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","-90.0")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("180.0","0.00")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("-180.0","0.00")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","90.01")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("0.00","-90.01")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("180.01","0.00")),
                () -> Assertions.assertFalse(validator.validateGetLastWeekRainingsAndDaytimeInput("-180.01","0.00"))
                );
    }
}