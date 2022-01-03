package dev.danielviana.relatorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.danielviana.relatorio.model.City;
import dev.danielviana.relatorio.model.State;
import dev.danielviana.relatorio.repository.CityRepository;
import dev.danielviana.relatorio.repository.StateRepository;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;
    
    @Autowired
    public CityServiceImpl(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }
    

    @Override
    public City create(Long stateId, City city) {
        Optional<State> state = stateRepository.findById(stateId);

        city.setState_id(state.get());

        return cityRepository.save(city);
    }

    
}
