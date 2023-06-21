package com.janwojnar.meteoapp.domain.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EndpointCallTo extends AbstractTo {

    private List<String> callParams = new ArrayList<>();

    private LocalDateTime timeOfCall;

}
