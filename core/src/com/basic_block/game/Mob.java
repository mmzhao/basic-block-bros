package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;

public class Mob extends DynamicEntity {

	public Mob() {
		x = Settings.screenWidth/2 - 400;
		y = Settings.screenHeight/2;
		
		width = Settings.mobWidth;
		height = Settings.mobHeight;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		lastBounds = new Rectangle();
		
		dx = 0;
		dy = 0;
		
		ay = Settings.gravity;
	}
	
	public Mob(float x, float y) {
		this.x = x;
		this.y = y;
		
		width = Settings.mobWidth;
		height = Settings.mobHeight;
		
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		lastBounds = new Rectangle();
		
		dx = 0;
		dy = 0;
		
		ay = Settings.gravity;
	}
	
}
