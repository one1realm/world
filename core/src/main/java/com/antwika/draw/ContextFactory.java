package com.antwika.draw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ContextFactory {
    private ContextFactory() {

    }

    public static Context createContext() {
        return new Context(
            new SpriteBatch(),
            new Texture("one-realm-logo.png"),
            new Texture("deck.png"),
            new FreeTypeFontGenerator(Gdx.files.internal("fonts/calibri.ttf")),
            new FreeTypeFontGenerator(Gdx.files.internal("fonts/calibrib.ttf")),
            new ShapeRenderer()
        );
    }
}
