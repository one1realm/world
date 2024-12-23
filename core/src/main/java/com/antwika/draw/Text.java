package com.antwika.draw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

public class Text {
    public static void draw(Context ctx, Vector2 position, String text, Color color, boolean bold) {
        final BitmapFont font;
        if (bold) {
            font = ctx.getFontBold();
        } else {
            font = ctx.getFont();
        }

        ctx.getSpriteBatch().begin();
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(ctx.getFont(), text);
        float textWidth = glyphLayout.width;
        float textHeight = glyphLayout.height;
        font.setColor(color);
        font.draw(ctx.getSpriteBatch(), text, position.x - textWidth/2f, position.y + textHeight/2f);
        ctx.getSpriteBatch().end();
    }
}
