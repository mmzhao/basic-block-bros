package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CharSelectScreen implements Screen {

	private final BasicGame bGame;
	
	OrthographicCamera camera;
	
	public CharSelectScreen(BasicGame bGame) {
		this.bGame = bGame;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}
	
	@Override
	public void show() {
		return;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        bGame.batch.begin();
        bGame.font.draw(bGame.batch, "You're now in Char Select.", 100, 150);
        bGame.batch.end();
        
        if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
            bGame.setScreen(new WorldMapScreen(bGame));
            dispose();
        }
	}

	@Override
	public void resize(int width, int height) {
		return;
	}

	@Override
	public void pause() {
		return;
	}

	@Override
	public void resume() {
		return;	
	}

	@Override
	public void hide() {
		return;
	}

	@Override
	public void dispose() {
		return;
	}

}