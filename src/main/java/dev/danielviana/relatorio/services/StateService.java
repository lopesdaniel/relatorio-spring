package dev.danielviana.relatorio.services;

import java.util.List;

import dev.danielviana.relatorio.model.State;

public interface StateService {

    public State create(State state);
    public Iterable<State> findAll();
    
}
