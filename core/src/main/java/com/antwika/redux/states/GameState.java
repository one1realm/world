package com.antwika.redux.states;

import com.antwika.redux.IState;

public record GameState(int handId, String deck) implements IState {}
