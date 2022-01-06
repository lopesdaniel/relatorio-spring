package dev.danielviana.relatorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.danielviana.relatorio.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
    
    @Query(value="SELECT city.* FROM cities as city, states as state WHERE city.state_id = state.id and city.state_id = :state_id", nativeQuery = true)
    public List<City> findAllCitiesByState(@Param("state_id") Long id);

}
