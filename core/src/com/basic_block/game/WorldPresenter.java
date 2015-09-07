package com.basic_block.game;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	// libgdx Array is basically an arraylist
	private Texture img;
	
	private MController controller;
	
	public WorldPresenter(final BasicGame game) {
		this.game = game;
		
		controller = new MController();
		world = new World(controller);
		
		// initial setup
		camera = new OrthographicCamera();
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		camera.setToOrtho(false, w, h);
		img = new Texture("badlogic.jpg");
		
	}

	@Override
	public void render(float delta) {
		// update world
		world.update(delta);
		
		int fps = Gdx.graphics.getFramesPerSecond();
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// update camera once per frame
		camera.update();
		// use coordinate system for current camera
		game.batch.setProjectionMatrix(camera.combined);
		
		// draw stuff
		game.batch.begin();
		game.batch.draw(img, world.player.getX(), world.player.getY(), world.player.getWidth(), world.player.getHeight());
		game.batch.draw(img, world.platform.getX(), world.platform.getY(), world.platform.getWidth(), world.platform.getHeight());
		for(Mob mob: world.mobs)
			game.batch.draw(img, mob.getX(), mob.getY(), mob.getWidth(), mob.getHeight());
		
        // fps display
		game.font.setColor(Color.RED);
        game.font.draw(game.batch, "fps: " + fps, 100, 1500);
        
        game.batch.end();
		// stop drawing stuff
		
		// stuff for changes, like movement etc
		
		// user input
        controller.reset();
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			controller.left = true;
			
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			controller.right = true;
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			controller.up = true;
		}
		
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
    }
}
