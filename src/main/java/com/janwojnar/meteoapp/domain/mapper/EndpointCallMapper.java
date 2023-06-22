package com.janwojnar.meteoapp.domain.mapper;

import com.janwojnar.meteoapp.domain.entity.AbstractEntity;
import com.janwojnar.meteoapp.domain.entity.EndpointCallEntity;
import com.janwojnar.meteoapp.domain.to.EndpointCallTo;

import java.util.stream.Collectors;

public class EndpointCallMapper {

    public static EndpointCallTo map2TO(EndpointCallEntity endpointCallEntity) {
        return EndpointCallTo
                .builder()
                .id(endpointCallEntity.getId())
                .geoWidth(endpointCallEntity.getGeoWidth())
                .geoLength(endpointCallEntity.getGeoLength())
                .timeOfCall(endpointCallEntity.getTimeOfCall())
                .build();
    }

    public static EndpointCallEntity map2Entity(EndpointCallTo endpointCallTo) {
        return EndpointCallEntity
                .builder()
                .id(endpointCallTo.getId())
                .geoWidth(endpointCallTo.getGeoWidth())
                .geoLength(endpointCallTo.getGeoLength())
                .timeOfCall(endpointCallTo.getTimeOfCall())
                .build();
    }
}
