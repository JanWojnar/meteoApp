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
        String geoWidth1 = "52°13′N";
        String geoLength1 = "21°00′E";

        EndpointCallTo endpointCallTo = EndpointCallTo.builder().timeOfCall(time).geoLength(geoLength1).geoWidth(geoWidth1)
                .build();

        EndpointCallTo savedEndpointCallTO = endpointCallService.save(endpointCallTo);

        Assertions.assertAll(
                () -> Assertions.assertEquals(time.getSecond(), savedEndpointCallTO.getTimeOfCall().getSecond()),
                () -> Assertions.assertEquals(geoWidth1, savedEndpointCallTO.getGeoWidth()),
                () -> Assertions.assertEquals(geoLength1, savedEndpointCallTO.getGeoLength()),
                () -> Assertions.assertNotNull(savedEndpointCallTO.getId())
        );
    }

    @Test
    void update() {
        LocalDateTime time = LocalDateTime.now();
        String geoWidth1 = "52°13′N";
        String geoLength1 = "21°00′E";

        String geoWidth2 = "32°13′N";
        String geoLength2 = "51°00′E";

        EndpointCallTo endpointCallTo = EndpointCallTo.builder().timeOfCall(time).geoLength(geoLength1).geoWidth(geoWidth1)
                .build();

        EndpointCallTo savedEndpointCallTO = endpointCallService.save(endpointCallTo);

        savedEndpointCallTO.setGeoWidth(geoWidth2);
        savedEndpointCallTO.setGeoLength(geoLength2);

        EndpointCallTo updated = endpointCallService.save(savedEndpointCallTO);

        Assertions.assertAll(
                () -> Assertions.assertEquals(time.getSecond(), updated.getTimeOfCall().getSecond()),
                () -> Assertions.assertEquals(geoWidth2, updated.getGeoWidth()),
                () -> Assertions.assertEquals(geoLength2, updated.getGeoLength()),
                () -> Assertions.assertNotNull(updated.getId())
        );
    }
}