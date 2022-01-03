package dev.danielviana.relatorio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.danielviana.relatorio.model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long>{
    
}
