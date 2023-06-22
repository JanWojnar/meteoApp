package com.janwojnar.meteoapp.dao;

import com.janwojnar.meteoapp.domain.entity.EndpointCallEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class RelationalDatabaseTest {

    @Autowired
    EndpointCallRepository endpointCallRepository;

    @BeforeEach
    void prepare() {
        endpointCallRepository.deleteAll();
    }

    @AfterEach
    void clean() {
        endpointCallRepository.deleteAll();
    }

    @Test
    void saveEndpoint(){
        EndpointCallEntity endpointCallEntity = new EndpointCallEntity();

        LocalDateTime time = LocalDateTime.now();
        String geoWidth = "52°13′N";
        String geoLength = "21°00′E";

        endpointCallEntity.setTimeOfCall(time);
        endpointCallEntity.setLatitude(geoWidth);
        endpointCallEntity.setLongitude(geoLength);

        endpointCallRepository.save(endpointCallEntity);

        List<EndpointCallEntity> endpointCallEntityList = endpointCallRepository.findAll();

        Assertions.assertAll(
                () -> Assertions.assertEquals(time.getSecond(), endpointCallEntityList.get(0).getTimeOfCall().getSecond()),
                () -> Assertions.assertEquals(geoWidth, endpointCallEntityList.get(0).getLatitude()),
                () -> Assertions.assertEquals(geoLength, endpointCallEntityList.get(0).getLongitude())
        );

        Assertions.assertEquals(time.getSecond(), endpointCallEntityList.get(0).getTimeOfCall().getSecond());
        Assertions.assertEquals(time.getSecond(), endpointCallEntityList.get(0).getTimeOfCall().getSecond());
        Assertions.assertEquals(time.getSecond(), endpointCallEntityList.get(0).getTimeOfCall().getSecond());

    }

}