package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class WorldMapScreen implements Screen{

	private final BasicGame bGame;
	
	private OrthographicCamera camera;
	
	public WorldMapScreen (BasicGame bGame) {
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
        bGame.font.draw(bGame.batch, "You're now in World Map, kid.", 100, 150);
        bGame.batch.end();
        
        
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}
	
}
