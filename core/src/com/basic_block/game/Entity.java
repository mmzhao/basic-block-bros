package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Entity {
	
	protected float x;
	protected float y;
	
	protected float width;
	protected float height;
	
	protected int state;
	
	protected Body body;
	protected Fixture fixture;
	
	protected Rectangle bounds;
	
	public Entity() {
		
	}
	
	public Entity(com.badlogic.gdx.physics.box2d.World world) {
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        
        body = world.createBody(bodyDef);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        
        fixture = body.createFixture(fixtureDef);
        
        shape.dispose();
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
		x = body.getPosition().x - width/2;
		y = body.getPosition().y - height/2;
	}
	
	public void setX(float x) {
		this.x = x;
		bounds.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
		bounds.y = y;
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
