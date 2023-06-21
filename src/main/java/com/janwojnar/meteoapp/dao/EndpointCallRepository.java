package com.janwojnar.meteoapp.dao;

import com.janwojnar.meteoapp.domain.entity.EndpointCallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointCallRepository extends JpaRepository<EndpointCallEntity, Long> {
}
