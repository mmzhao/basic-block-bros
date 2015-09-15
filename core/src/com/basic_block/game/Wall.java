package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Wall extends Entity{
	
	public Wall(com.badlogic.gdx.physics.box2d.World pWorld) {
		this(0, pWorld);
	}
	
	public Wall(float tileOffset, com.badlogic.gdx.physics.box2d.World world) {
		x = Settings.screenWidth/2 - 10 + tileOffset;
		y = 25;
		width = 20;
		height = 1;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x + width/2, y + height/2);
        
        body = world.createBody(bodyDef);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        
        fixture = body.createFixture(fixtureDef);
        
        shape.dispose();
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
