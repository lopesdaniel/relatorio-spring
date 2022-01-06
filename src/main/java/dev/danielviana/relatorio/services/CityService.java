package dev.danielviana.relatorio.services;

import java.util.List;

import dev.danielviana.relatorio.model.City;

public interface CityService {

    public City create(Long stateId, City city);

    public List<City> reportAllCitiesByState(Long stateId);
    
}
