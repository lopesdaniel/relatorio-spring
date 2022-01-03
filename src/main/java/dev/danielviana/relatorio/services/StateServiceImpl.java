package dev.danielviana.relatorio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.danielviana.relatorio.model.State;
import dev.danielviana.relatorio.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService{
    
    @Autowired
    private StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State create(State state){
        return stateRepository.save(state);
    }

    @Override
    public Iterable<State> findAll() {
        return stateRepository.findAll();
    }

}
