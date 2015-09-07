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
	
	public Tile(float tileOffset) {
		minX = 0;
		maxX = Settings.screenWidth;
		minY = 0;
		maxY = Settings.screenHeight;
		tileBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		platforms = new Array<Platform>();
		walls = new Array<Wall>();
		mobs = new Array<Mob>();
		pickups = new Array<Pickup>();
		
		for(int i = 0; i < 1; i++) {
			Mob m = new Mob(tileOffset);
//			m.setX((i % 200) * 10);
//			m.setY((i / 200) * 10);
			
			mobs.add(m);
		}
		platforms.add(new Platform(tileOffset));
		walls.add(new Wall(tileOffset));
		pickups.add(new Pickup(tileOffset));
	}
	
}
