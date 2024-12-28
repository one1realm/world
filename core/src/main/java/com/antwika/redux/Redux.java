package com.antwika.redux;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Redux<StateType extends IState> {
    private final Queue<IAction> actions = new ConcurrentLinkedDeque<>();
    private final List<IReducer<StateType>> reducers = new ArrayList<>();
    private final List<StateType> states = new ArrayList<>();

    public Redux(StateType state) {
        setState(state);
    }

    public static <StateType extends IState> Redux<StateType> of(StateType state) {
        return new Redux<>(state);
    }

    public StateType getCurrentState() {
        return states.getLast();
    }

    public void setState(StateType state) {
        states.add(state);
    }

    public void addReducer(IReducer<StateType> reducer) {
        reducers.add(reducer);
    }

    public void dispatch(IAction action) {
        actions.add(action);
    }

    public void update() {
        while(!actions.isEmpty()) {
            final var action = actions.poll();
            for (var reducer : reducers) {
                final var state = getCurrentState();
                final var newState = reducer.reduce(this, state, action);
                setState(newState);
            }
        }
    }
}
