package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;

public class Entity {
	
	protected float x;
	protected float y;
	
	protected float width;
	protected float height;
	
	protected int state;
	
	protected Rectangle bounds;
	
	public Entity() {
		x = Settings.screenWidth/2 - 500;
		y = 100;
		width = 1000;
		height = 10;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
	}
	
	public void setBounds() {
		bounds.x = x;
		bounds.y = y;
		bounds.width = width;
		bounds.height = height;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void update(float delta) {
		
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public int getState() {
		return state;
	}
	
}
