package dev.danielviana.relatorio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.danielviana.relatorio.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
    
}
