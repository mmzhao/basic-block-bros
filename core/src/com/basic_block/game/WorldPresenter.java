package com.basic_block.game;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class WorldPresenter implements Screen{
	
	final BasicGame game;
	
	private final World world;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	// libgdx Array is basically an arraylist
	private Texture img;
	
	public WorldPresenter(final BasicGame game) {
		this.game = game;
		
		world = new World();
		
		// initial setup
		camera = new OrthographicCamera();
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		camera.setToOrtho(false, w, h);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render(float delta) {
		// update world
		world.update(delta);
		
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// update camera once per frame
		camera.update();
		// use coordinate system for current camera
		game.batch.setProjectionMatrix(camera.combined);
		
		// draw stuff
		game.batch.begin();
		game.batch.draw(img, world.player.getX(), world.player.getY(), world.player.getWidth(), world.player.getHeight());
		game.batch.draw(img, world.wall.getX(), world.wall.getY(), world.wall.getWidth(), world.wall.getHeight());
        game.batch.end();
		// stop drawing stuff
		
		// stuff for changes, like movement etc
		
		// user input
//		if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//		if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
		
		// automatic updates
		
	    
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void dispose() {
        img.dispose();
        batch.dispose();
    }
}
