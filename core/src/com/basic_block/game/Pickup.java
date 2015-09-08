package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Pickup extends DynamicEntity{
	
	public Pickup(com.badlogic.gdx.physics.box2d.World pWorld) {
		this(0, pWorld);
	}
	
	public Pickup(float tileOffset, com.badlogic.gdx.physics.box2d.World world) {
		
		x = 64 + tileOffset;
		y = 64;
		
		width = 8;
		height = 8;
		
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
	
}
