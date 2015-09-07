package com.basic_block.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class World {
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	Rectangle roomBounds;

	Player player;
	
	Array<Platform> platforms;
	
	Array<Wall> walls;
	
	Array<Mob> mobs;
	
	Array<Pickup> pickups;
	
	int hitCounter = 0;
	int pickupCounter = 0;
	
	public World(MController controller) {
		minX = 0;
		maxX = Settings.screenWidth * 3;
		minY = 0;
		maxY = Settings.screenHeight;
		roomBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		player = new Player(controller);
		platforms = new Array<Platform>();
		walls = new Array<Wall>();
		mobs = new Array<Mob>();
		pickups = new Array<Pickup>();
		
		for(int i = 0; i < 1; i++) {
			Mob m = new Mob();
//			m.setX((i % 200) * 10);
//			m.setY((i / 200) * 10);
			
			mobs.add(m);
		}
		platforms.add(new Platform());
		walls.add(new Wall());
		pickups.add(new Pickup());
		
	}
	
	public void update(float delta) {
		// do updates
		player.update(delta);
		for(Mob mob: mobs)
			mob.update(delta);
		
		// check collisions
		for(Platform platform: platforms) {
			if(Collision.intersect(player, platform)) {
				Collision.fixIntersection(player, platform, delta);
			}
		}
		for(Wall wall: walls) {
			if(Collision.intersect(player, wall)) {
				Collision.fixIntersection(player, wall, delta);
			}
		}
		for(Mob mob: mobs){
			for(Platform platform: platforms) {
				if(Collision.intersect(mob, platform)) {
					Collision.fixIntersection(mob, platform, delta);
				}
			}
			for(Wall wall: walls) {
				if(Collision.intersect(mob, wall)) {
					Collision.fixIntersection(mob, wall, delta);
				}
			}
			if(Collision.intersect(player, mob)) {
				hitCounter++;
			}
		}
		player.stateChange(delta);
		for(Pickup pickup: pickups) {
			if(Collision.intersect(player, pickup)) {
				pickupCounter++;
			}
		}
	}
	
}
