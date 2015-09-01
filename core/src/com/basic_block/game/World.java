package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class World {
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	Rectangle roomBounds;

	Player player;
	
	Entity wall;
	
	public World() {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		minX = 0;
		maxX = w;
		minY = 0;
		maxY = h;
		roomBounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		player = new Player();
		wall = new Entity();
	}
	
	public void update(float delta) {
		player.update(delta);
		if(Collision.intersect(player, wall)) {
			Collision.fixIntersection(player, wall, delta);
		}
	}
	
}
