package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;

public class Wall extends Entity{
	
	public Wall() {
		x = Settings.screenWidth/2 - 500;
		y = 1300;
		width = 1000;
		height = 10;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
	}
	
	public Wall(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle();
		setBounds();
	}
	
}
