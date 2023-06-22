package com.janwojnar.meteoapp.domain.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EndpointCallTo extends AbstractTo {

    private String geoLength;
    private String geoWidth;
    private LocalDateTime timeOfCall;

}
