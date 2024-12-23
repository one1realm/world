package com.antwika.draw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import lombok.Getter;

@Getter
public class Context implements Disposable {
    private final SpriteBatch spriteBatch;
    private final Texture oneRealmLogo;
    private final Texture deck;
    private final FreeTypeFontGenerator fontGenerator;
    private final FreeTypeFontGenerator fontGeneratorBold;
    private final ShapeRenderer shapeRenderer;
    private final BitmapFont font;
    private final BitmapFont fontBold;

    public Context(SpriteBatch spriteBatch, Texture oneRealmLogo, Texture deck, FreeTypeFontGenerator fontGenerator, FreeTypeFontGenerator fontGeneratorBold, ShapeRenderer shapeRenderer) {
        this.spriteBatch = spriteBatch;
        this.oneRealmLogo = oneRealmLogo;
        this.deck = deck;
        this.fontGenerator = fontGenerator;
        this.fontGeneratorBold = fontGeneratorBold;
        this.shapeRenderer = shapeRenderer;

        oneRealmLogo.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        deck.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        final var fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 16;
        font = getFontGenerator().generateFont(fontParameter);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        final var fontParameterBold = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameterBold.size = 16;
        fontBold = getFontGeneratorBold().generateFont(fontParameterBold);
        fontBold.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        oneRealmLogo.dispose();
        deck.dispose();
        fontGenerator.dispose();
        fontGeneratorBold.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }
}
