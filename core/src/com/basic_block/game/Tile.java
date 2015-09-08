package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Tile {
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	Rectangle tileBounds;

	Array<Platform> platforms;
	
	Array<Wall> walls;
	
	Array<Mob> mobs;
	
	Array<Pickup> pickups;
	
	public Tile(float tileOffset, com.badlogic.gdx.physics.box2d.World pWorld) {
		minX = tileOffset;
		maxX = Settings.screenWidth + tileOffset;
		minY = 0;
		maxY = Settings.screenHeight;
		tileBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		platforms = new Array<Platform>();
		walls = new Array<Wall>();
		mobs = new Array<Mob>();
		pickups = new Array<Pickup>();
		
		for(int i = 0; i < 1; i++) {
			Mob m = new Mob(tileOffset, pWorld);
//			m.setX((i % 200) * 10);
//			m.setY((i / 200) * 10);
			
			mobs.add(m);
		}
		platforms.add(new Platform(tileOffset, pWorld));
//		platforms.add(new Platform(150, 120, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 140, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 160, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 180, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 200, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 220, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 240, 2360, 10, tileOffset));
//		platforms.add(new Platform(150, 260, 2360, 10, tileOffset));
		walls.add(new Wall(tileOffset, pWorld));
		pickups.add(new Pickup(tileOffset, pWorld));
	}
	
}
