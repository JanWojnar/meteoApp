package com.janwojnar.meteoapp.service.impl;

import com.janwojnar.meteoapp.dao.EndpointCallRepository;
import com.janwojnar.meteoapp.domain.mapper.EndpointCallMapper;
import com.janwojnar.meteoapp.domain.to.EndpointCallTo;
import com.janwojnar.meteoapp.service.EndpointCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class EndpointCallServiceImpl implements EndpointCallService {

    @Autowired
    private EndpointCallRepository endpointCallRepository;

    @Override
    public EndpointCallTo save(EndpointCallTo to) {
        return EndpointCallMapper.map2TO(endpointCallRepository.save(EndpointCallMapper.map2Entity(to)));
    }

    @Override
    public EndpointCallTo update(EndpointCallTo to) {

        if(Objects.isNull(to.getId())){
            throw new IllegalArgumentException("Given transfer object has no id!");
        }
        return EndpointCallMapper.map2TO(endpointCallRepository.save(EndpointCallMapper.map2Entity(to)));
    }

    @Override
    public void remove(Long id) {
        endpointCallRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        endpointCallRepository.deleteAll();
    }

    @Override
    public List<EndpointCallTo> findAll() {
        return endpointCallRepository.findAll().stream().map(EndpointCallMapper::map2TO).collect(Collectors.toList());
    }

    @Override
    public EndpointCallTo findById(Long id) {
        return EndpointCallMapper.map2TO(endpointCallRepository.findById(id).orElseThrow());
    }
}
