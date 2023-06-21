package com.janwojnar.meteoapp.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(name = "PARAMS")
    @ElementCollection
    private List<String> callParams = new ArrayList<>();

    @Column(name = "TIME_OF_CALL")
    private LocalDateTime timeOfCall;
}
