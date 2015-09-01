package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Entity {
	
	protected float x;
	protected float y;
	
	protected float width;
	protected float height;
	
	protected int state;
	
	protected Rectangle bounds;
	
	public Entity() {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		x = w/2 - 500;
		y = 100;
		width = 1000;
		height = 10;
		state = 0;
		bounds = new Rectangle();
	}
	
	public Rectangle getBounds() {
		bounds.x = x;
		bounds.y = y;
		bounds.width = width;
		bounds.height = height;
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
