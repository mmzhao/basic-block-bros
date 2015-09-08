package com.basic_block.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class WorldPresenter implements Screen{
	
	final BasicGame game;
	
	private final World world;
	
	private OrthographicCamera camera;
	
	private MController controller;
	
	public WorldPresenter(final BasicGame game) {
		this.game = game;
		
		controller = new MController();
		world = new World(controller);
		
		// initial setup
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Settings.screenWidth, Settings.screenHeight);
	}

	@Override
	public void render(float delta) {
		
		// update world
		world.update(delta);
		
		int fps = Gdx.graphics.getFramesPerSecond();
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// update camera once per frame
		camera.position.x = world.player.getX() + world.player.getWidth() / 2;
		if(camera.position.x < world.checkpoint)
			camera.position.x = world.checkpoint;
		if(camera.position.x > world.maxX - Settings.screenWidth/2)
			camera.position.x = world.maxX - Settings.screenWidth/2;
		camera.update();
		world.checkpoint = camera.position.x;
		// use coordinate system for current camera
		game.batch.setProjectionMatrix(camera.combined);
		
		// draw stuff
		game.batch.begin();
		for(Platform platform: world.platforms) {
			draw(platform);
		}
		for(Wall wall: world.walls) {
			draw(wall);
		}
		for(Mob mob: world.mobs) {
			draw(mob);
		}
		for(Pickup pickup: world.pickups) {
			draw(pickup);
		}
		draw(world.player);
		
//		game.batch.draw(img, world.platform.getX(), world.platform.getY(), world.platform.getWidth(), world.platform.getHeight());
//		game.batch.draw(img, world.wall.getX(), world.wall.getY(), world.wall.getWidth(), world.wall.getHeight());
//		game.batch.draw(img, mob.getX(), mob.getY(), mob.getWidth(), mob.getHeight());
//		game.batch.draw(img, world.pickup.getX(), world.pickup.getY(), world.pickup.getWidth(), world.pickup.getHeight());
		
        // fps display
		game.font.setColor(Color.RED);
		game.font.draw(game.batch, "fps: " + fps, 100 + world.checkpoint - Settings.screenWidth/2, 1500);
		game.font.draw(game.batch, "hits: " + world.hitCounter, 100 + world.checkpoint - Settings.screenWidth/2, 1450);
		game.font.draw(game.batch, "pickups" + world.pickupCounter, 100 + world.checkpoint - Settings.screenWidth/2, 1400);
        
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
	
	private void draw(Entity e) {
		game.batch.draw(Settings.img, e.getX(), e.getY(), e.getWidth(), e.getHeight());
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
        Settings.img.dispose();
    }
}
