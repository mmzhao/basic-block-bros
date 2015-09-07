package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;

public class DynamicEntity extends Entity{

	// velocities
	protected float dx;
	protected float dy;
	
	// acceleration
	protected float ay;
	
	// Rectangle location for last frame
	protected Rectangle lastBounds;
	
	protected final float TIMESCALE = 10;
	
	public DynamicEntity() {
		x = Settings.screenWidth/2 - 500;
		y = 100;
		width = 1000;
		height = 10;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		lastBounds = new Rectangle();
		
		dx = 0;
		dy = 0;
		
		ay = Settings.gravity;
	}
	
	public void update(float delta) {
		// set lastBounds
		setLastBounds();
		
//		float d = delta * TIMESCALE;
		dy += ay * delta;
		x += dx * delta;
		y += dy * delta;
		
		// set bounds
		setBounds();
	}
	
	public void setLastBounds() {
		lastBounds.x = x;
		lastBounds.y = y;
		lastBounds.width = width;
		lastBounds.height = height;
	}
	
	public Rectangle getLastBounds() {
		return lastBounds;
	}
	
	public void setDX(float dx) {
		this.dx = dx;
	}
	
	public void setDY(float dy) {
		this.dy = dy;
	}
	
	public float getDX() {
		return dx;
	}
	
	public float getDY() {
		return dy;
	}
	
}
