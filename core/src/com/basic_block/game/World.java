package com.basic_block.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	Rectangle roomBounds;

	private final com.badlogic.gdx.physics.box2d.World world;

	Player player;
	
	Array<Platform> platforms;
	
	Array<Wall> walls;
	
	Array<Mob> mobs;
	
	Array<Pickup> pickups;
	
	Array<Tile> tiles;
	
	// can never go backwards, so this is a checkpoint
	float checkpoint;
	
	int hitCounter = 0;
	int pickupCounter = 0;
	
	public World(MController controller) {
		
		minX = 0;
		maxX = 0;
		minY = 0;
		maxY = Settings.screenHeight;
		roomBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);

		world = new com.badlogic.gdx.physics.box2d.World(new Vector2(0, -98f), true);
		
		player = new Player(controller, world);
		
		platforms = new Array<Platform>();
		walls = new Array<Wall>();
		mobs = new Array<Mob>();
		pickups = new Array<Pickup>();
		
		tiles = new Array<Tile>();
		tiles.add(new Tile(0, world));
		for(int i = 0; i < 3; i++){
			tiles.add(new Tile(tiles.get(i).maxX, world));
		}
		updateTiles();
		
		checkpoint = Settings.screenWidth/2;
	}
	
	public void update(float delta) {
		updateTiles();
		world.step(delta, 6, 2);
		
		// do updates
		player.update(delta);
		for(Mob mob: mobs)
			mob.update(delta);
		for(Platform platform: platforms)
			platform.update(delta);
		for(Wall wall: walls)
			wall.update(delta);
		for(Pickup pickup: pickups)
			pickup.update(delta);
		
		// check collisions
		
//		for(Platform platform: platforms) {
//			if(Collision.intersect(player, platform)) {
//				Collision.fixIntersection(player, playerdx, playerdy, platform, delta);
//			}
//		}
//		for(Wall wall: walls) {
//			if(Collision.intersect(player, wall)) {
//				Collision.fixIntersection(player, playerdx, playerdy, wall, delta);
//			}
//		}
//		for(Mob mob: mobs){
//			
//			// keep track of old mob velocities for collision adjustments
//			float mobdx = mob.dx;
//			float mobdy = mob.dy;
//			
//			for(Platform platform: platforms) {
//				if(Collision.intersect(mob, platform)) {
//					Collision.fixIntersection(mob, mobdx, mobdy, platform, delta);
//				}
//			}
//			for(Wall wall: walls) {
//				if(Collision.intersect(mob, wall)) {
//					Collision.fixIntersection(mob, mobdx, mobdy, wall, delta);
//				}
//			}
//			if(Collision.intersect(player, mob)) {
//				hitCounter++;
//			}
//		}
		player.stateChange(delta);
//		for(Pickup pickup: pickups) {
//			if(Collision.intersect(player, pickup)) {
//				pickupCounter++;
//			}
//		}
	}
	
	public void updateTiles() {
		if(tiles.size == 0) {
			return;
		}
		else if(tiles.get(0).minX < checkpoint + Settings.screenWidth) {
			Tile newTile = tiles.removeIndex(0);
			platforms.addAll(newTile.platforms);
			walls.addAll(newTile.walls);
			mobs.addAll(newTile.mobs);
			pickups.addAll(newTile.pickups);
			
			maxX = newTile.maxX;
			roomBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
			
			updateTiles();
		}
	}
	
}
