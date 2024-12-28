package com.antwika.redux.reducers;

import com.antwika.redux.IAction;
import com.antwika.redux.IReducer;
import com.antwika.redux.IState;
import com.antwika.redux.Redux;
import com.antwika.redux.actions.HandEndAction;
import com.antwika.redux.states.GameState;
import com.antwika.redux.actions.IncrementHandIdAction;

public class IncrementHandIdReducer<StateType extends IState> implements IReducer<StateType> {
    @Override
    public StateType reduce(Redux<StateType> redux, StateType state, IAction action) {
        if (state instanceof GameState gameState) {
            if (action instanceof IncrementHandIdAction) {
                redux.dispatch(new HandEndAction());
                System.out.println("Hand id incremented");
                return (StateType) new GameState(gameState.handId() + 1, gameState.deck());
            } else {
                return state;
            }
        } else {
            return state;
        }
    }
}
