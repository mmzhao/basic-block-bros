package com.basic_block.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class DynamicEntity extends Entity{
	
	// Rectangle location for last frame
	
	protected final float TIMESCALE = 10;
	
	public DynamicEntity() {
		
	}
	
	public DynamicEntity(com.badlogic.gdx.physics.box2d.World world) {
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
	
	public void update(float delta) {
		x = body.getPosition().x - width/2;
		y = body.getPosition().y - height/2;
		
		// set bounds
		setBounds();
	}
	
	
}
