package com.antwika;

import com.antwika.draw.Context;
import com.antwika.draw.ContextFactory;
import com.antwika.draw.Table;
import com.antwika.state.SeatState;
import com.antwika.state.TableState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private Context ctx;

    @Override
    public void create() {
        ctx = ContextFactory.createContext();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.17f, 0.2f, 0.21f, 1f);

        TableState tableState = TableState.builder()
            .tableName("OneRealm Poker")
            .stakes("100/200")
            .communityCards("2c5h6cThKs")
            .pot(Pot.computePots(new int[]{60, 50, 40, 30, 20, 10}))
            .seats(new SeatState[]{
                SeatState.builder().chips(1000).cards("AhKh").committedChips(100).build(),
                SeatState.builder().chips(2000).cards("Ts8s").committedChips(200).build(),
                SeatState.builder().chips(3000).cards("6d6h").committedChips(300).build(),
                SeatState.builder().chips(4000).cards("JdJs").committedChips(400).build(),
                SeatState.builder().chips(5000).cards("4c7h").committedChips(500).build(),
                SeatState.builder().chips(6000).cards("7cKc").committedChips(600).button(true).build()
            })
            .build();

        Table.draw(ctx, tableState, new Vector2(320, 240));
    }

    @Override
    public void dispose() {
        ctx.dispose();
    }
}
