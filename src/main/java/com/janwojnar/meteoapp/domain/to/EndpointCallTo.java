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

    private String longitude;
    private String latitude;
    private LocalDateTime timeOfCall;

}
