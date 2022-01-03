package dev.danielviana.relatorio.services;

import dev.danielviana.relatorio.model.City;

public interface CityService {

    public City create(Long stateId, City city);
    
}
