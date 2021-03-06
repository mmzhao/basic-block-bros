package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Mob extends DynamicEntity {

	public Mob(com.badlogic.gdx.physics.box2d.World pWorld) {
		this(0, pWorld);
	}
	
	public Mob(float tileOffset, com.badlogic.gdx.physics.box2d.World world) {
		x = Settings.screenWidth/2 - 400 + tileOffset;
		y = Settings.screenHeight/2;
		
		width = Settings.mobWidth;
		height = Settings.mobHeight;
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
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
	
	public Mob(float x, float y, com.badlogic.gdx.physics.box2d.World world) {
		this.x = x;
		this.y = y;
		
		width = Settings.mobWidth;
		height = Settings.mobHeight;
		
		state = 0;
		
		bounds = new Rectangle();
		setBounds();
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
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
	
}
