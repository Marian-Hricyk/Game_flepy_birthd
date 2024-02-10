package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
  Texture img;
  Vector2 position;
  int max_height = 600;
  int min_height = 0;
  float vy;
  float gravity;

  public Bird() {
    img = new Texture("bird1.png");
    position = new Vector2(200, 380);
    vy = 0;
    gravity = -0.5f;
  }

  public void render(SpriteBatch batch) {
    batch.draw(img, position.x, position.y);
  }

  public void update() {
    if (position.y >= max_height) {
      position.y = 600;
    }
    if (position.y <= min_height) {
      position.y = 0;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      vy = 10;
    }
    vy += gravity;
    position.y += vy;
  }

  public void recreate() {
    position = new Vector2(100, 380);
    vy = 0;
  }
}
