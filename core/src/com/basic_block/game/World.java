package com.basic_block.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class World {
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	Rectangle roomBounds;

	Player player;
	
	Platform platform;
	
	ArrayList<Mob> mobs;
	
	
	public World(MController controller) {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		minX = 0;
		maxX = w;
		minY = 0;
		maxY = h;
		roomBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		player = new Player(controller);
		platform = new Platform();
		mobs = new ArrayList<Mob>();
		for(int i = 0; i < 1; i++) {
			Mob m = new Mob();
//			m.setX((i % 200) * 10);
//			m.setY((i / 200) * 10);
			
			mobs.add(m);
		}
		
	}
	
	public void update(float delta) {
		// do updates
		player.update(delta);
		for(Mob mob: mobs)
			mob.update(delta);
		
		// check collisions
		if(Collision.intersect(player, platform)) {
			Collision.fixIntersection(player, platform, delta);
		}
		for(Mob mob: mobs){
			if(Collision.intersect(mob, platform)) {
				Collision.fixIntersection(mob, platform, delta);
			}
		}
		
		player.stateChange(delta);
//		if(Collision.intersect(player, mob)) {
//			System.out.println("hit");
//		}
		
	}
	
}
