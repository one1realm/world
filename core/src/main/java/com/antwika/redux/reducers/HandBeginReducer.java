package com.antwika.redux.reducers;

import com.antwika.redux.IAction;
import com.antwika.redux.IReducer;
import com.antwika.redux.IState;
import com.antwika.redux.Redux;
import com.antwika.redux.actions.HandBeginAction;
import com.antwika.redux.actions.IncrementHandIdAction;
import com.antwika.redux.states.GameState;

public class HandBeginReducer<StateType extends IState> implements IReducer<StateType> {
    @Override
    public StateType reduce(Redux<StateType> redux, StateType state, IAction action) {
        if (state instanceof GameState gameState) {
            if (action instanceof HandBeginAction) {
                redux.dispatch(new IncrementHandIdAction());
                System.out.println("Hand begun");
                return state;
            } else {
                return state;
            }
        } else {
            return state;
        }
    }
}
