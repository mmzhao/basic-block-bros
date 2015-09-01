package com.basic_block.game;

public class DynamicEntity extends Entity{

	// velocities
	protected float dx;
	protected float dy;
	
	// acceleration
	protected float ay;
	
	protected final float TIMESCALE = 10;
	
	public DynamicEntity() {
		
		super();
		
		dx = 0;
		dy = 0;
		
		ay = -500;
	}
	
	public void update(float delta) {
		float d = delta * TIMESCALE;
		dy += ay * delta;
		x += dx * delta;
		y += dy * delta;
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
