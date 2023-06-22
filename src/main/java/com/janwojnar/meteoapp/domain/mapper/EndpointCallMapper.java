package com.janwojnar.meteoapp.domain.mapper;

import com.janwojnar.meteoapp.domain.entity.EndpointCallEntity;
import com.janwojnar.meteoapp.domain.to.EndpointCallTo;

public class EndpointCallMapper {

    public static EndpointCallTo map2TO(EndpointCallEntity endpointCallEntity) {
        return EndpointCallTo
                .builder()
                .id(endpointCallEntity.getId())
                .latitude(endpointCallEntity.getLatitude())
                .longitude(endpointCallEntity.getLongitude())
                .timeOfCall(endpointCallEntity.getTimeOfCall())
                .build();
    }

    public static EndpointCallEntity map2Entity(EndpointCallTo endpointCallTo) {
        return EndpointCallEntity
                .builder()
                .id(endpointCallTo.getId())
                .latitude(endpointCallTo.getLatitude())
                .longitude(endpointCallTo.getLongitude())
                .timeOfCall(endpointCallTo.getTimeOfCall())
                .build();
    }
}
