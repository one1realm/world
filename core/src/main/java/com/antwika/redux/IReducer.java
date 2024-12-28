package com.antwika.redux;

public interface IReducer<StateType extends IState> {
    StateType reduce(Redux<StateType> redux, StateType state, IAction action);
}
