package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;

public class Platform extends Entity {

	public Platform() {
		x = 50;
		y = 100;
		width = 2460;
		height = 10;
		
		bounds = new Rectangle();
		setBounds();
	}
	
	public Platform(float tileOffset) {
		x = 50 + tileOffset;
		y = 100;
		width = 2460;
		height = 10;
		
		bounds = new Rectangle();
		setBounds();
	}
	
	public Platform(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
		
		bounds = new Rectangle();
		setBounds();
	}
	
}
