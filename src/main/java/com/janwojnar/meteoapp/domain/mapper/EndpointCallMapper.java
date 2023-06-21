package com.janwojnar.meteoapp.domain.mapper;

import com.janwojnar.meteoapp.domain.entity.EndpointCallEntity;
import com.janwojnar.meteoapp.domain.to.EndpointCallTo;

public class EndpointCallMapper {

    public static EndpointCallTo map2TO(EndpointCallEntity endpointCallEntity) {
        return EndpointCallTo
                .builder()
                .id(endpointCallEntity.getId())
                .callParams(endpointCallEntity.getCallParams())
                .timeOfCall(endpointCallEntity.getTimeOfCall())
                .build();
    }

    public static EndpointCallEntity map2Entity(EndpointCallTo endpointCallTo) {
        return EndpointCallEntity
                .builder()
                .id(endpointCallTo.getId())
                .callParams(endpointCallTo.getCallParams())
                .timeOfCall(endpointCallTo.getTimeOfCall())
                .build();
    }
}
