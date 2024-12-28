package com.antwika.redux;

import com.antwika.redux.actions.HandBeginAction;
import com.antwika.redux.reducers.HandBeginReducer;
import com.antwika.redux.reducers.HandEndReducer;
import com.antwika.redux.reducers.IncrementHandIdReducer;
import com.antwika.redux.states.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReduxTest {
    @Test
    public void test() {
        final var redux = Redux.of(new GameState(0, "2c3c4c5c6c7c8c9cTcJcQcKcAc2d3d4d5d6d7d8d9dTdJdQdKdAd2h3h4h5h6h7h8h9hThJhQhKhAh2s3s4s5s6s7s8s9sTsJsQsKsAs"));
        redux.addReducer(new HandBeginReducer<>());
        redux.addReducer(new IncrementHandIdReducer<>());
        redux.addReducer(new HandEndReducer<>());

        assertEquals(0, redux.getCurrentState().handId());

        redux.dispatch(new HandBeginAction());

        redux.update();

        assertEquals(1, redux.getCurrentState().handId());
    }
}
