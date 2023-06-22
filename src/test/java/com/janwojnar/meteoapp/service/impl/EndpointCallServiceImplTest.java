package com.janwojnar.meteoapp.service.impl;

import com.janwojnar.meteoapp.domain.to.EndpointCallTo;
import com.janwojnar.meteoapp.domain.service.EndpointCallService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class EndpointCallServiceImplTest {

    @Autowired
    EndpointCallService endpointCallService;


    @BeforeEach
    void prepare() {
        endpointCallService.deleteAll();
    }

    @AfterEach
    void clean() {
        endpointCallService.deleteAll();
    }
    @Test
    void save() {
        LocalDateTime time = LocalDateTime.now();
        String latitude1 = "52°13′N";
        String longitude1 = "21°00′E";

        EndpointCallTo endpointCallTo = EndpointCallTo.builder().timeOfCall(time).longitude(longitude1).latitude(latitude1)
                .build();

        EndpointCallTo savedEndpointCallTO = endpointCallService.save(endpointCallTo);

        Assertions.assertAll(
                () -> Assertions.assertEquals(time.getSecond(), savedEndpointCallTO.getTimeOfCall().getSecond()),
                () -> Assertions.assertEquals(latitude1, savedEndpointCallTO.getLatitude()),
                () -> Assertions.assertEquals(longitude1, savedEndpointCallTO.getLongitude()),
                () -> Assertions.assertNotNull(savedEndpointCallTO.getId())
        );
    }

    @Test
    void update() {
        LocalDateTime time = LocalDateTime.now();
        String latitude1 = "52°13′N";
        String longitude1 = "21°00′E";

        String latitude2 = "32°13′N";
        String longitude2 = "51°00′E";

        EndpointCallTo endpointCallTo = EndpointCallTo.builder().timeOfCall(time).latitude(latitude1).longitude(longitude1)
                .build();

        EndpointCallTo savedEndpointCallTO = endpointCallService.save(endpointCallTo);

        savedEndpointCallTO.setLatitude(latitude2);
        savedEndpointCallTO.setLongitude(longitude2);

        EndpointCallTo updated = endpointCallService.save(savedEndpointCallTO);

        Assertions.assertAll(
                () -> Assertions.assertEquals(time.getSecond(), updated.getTimeOfCall().getSecond()),
                () -> Assertions.assertEquals(latitude2, updated.getLatitude()),
                () -> Assertions.assertEquals(longitude2, updated.getLongitude()),
                () -> Assertions.assertNotNull(updated.getId())
        );
    }
}