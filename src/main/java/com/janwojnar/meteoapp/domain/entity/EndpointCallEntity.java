package com.janwojnar.meteoapp.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "ENDPOINT_CALL")
public class EndpointCallEntity extends AbstractEntity{

    @Column(name = "GEO_LENGTH")
    private String geoLength;

    @Column(name = "GEO_WIDTH")
    private String geoWidth;

    @Column(name = "TIME_OF_CALL")
    private LocalDateTime timeOfCall;
}
