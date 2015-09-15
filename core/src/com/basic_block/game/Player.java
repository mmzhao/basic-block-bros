package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Player extends DynamicEntity{
	
	private MController controller;
	
	private final int STAND_STATE = 0;
	private final int JUMP_STATE = 1;
	private final int FALL_STATE = 2;
	private final int RUN_RIGHT_STATE = 3;
	private final int RUN_LEFT_STATE = 4;
	private final int JUMP_RIGHT_STATE = 5;
	private final int JUMP_LEFT_STATE = 6;
	private final int FALL_LEFT_STATE = 7;
	private final int FALL_RIGHT_STATE = 8;
	private final int LANDING_STATE = 9;
	
	private float justLanded;
	
	private Fixture fFixture;
	
	int state;
	
	boolean isOnGround;
	
	private Vector2 hForce;
	
	public Player(MController controller, com.badlogic.gdx.physics.box2d.World world) {

		this.controller = controller;
        
		x = Settings.screenWidth/2;
		y = Settings.screenHeight/2;
		
		hForce = new Vector2(0, 0);
		
		justLanded = 0;
		
		width = Settings.playerWidth;
		height = Settings.playerHeight;
		
		bounds = new Rectangle();
		setBounds();
		
		state = STAND_STATE;
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x + width/2, y + height/2);
        
        body = world.createBody(bodyDef);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 10f;
        
        fixture = body.createFixture(fixtureDef);
        fixture.setUserData("playerBody");
        
        
        shape.setAsBox(.5f, .5f, new Vector2(0, -height), 0);
        fixtureDef.isSensor = true;
       
        
        fFixture = body.createFixture(fixtureDef);
        fFixture.setUserData("playerFoot");
        
        body.setUserData("playerBody");
        body.setLinearDamping(0);
        
        shape.dispose();
        
        world.setContactListener(new ContactListener() {

	        @Override
	        public void beginContact(Contact contact) {
		        if(contact.getFixtureA().getUserData() != null &&
		        		contact.getFixtureA().getUserData().equals("playerFoot"))
		        	isOnGround = true;
		        if(contact.getFixtureB().getUserData() != null &&
		               contact.getFixtureB().getUserData().equals("playerFoot"))
		        	isOnGround = true;
	        }
	
	        @Override
	        public void endContact(Contact contact) {
	        	if(contact.getFixtureA().getUserData() != null &&
		        		contact.getFixtureA().getUserData().equals("playerFoot"))
		        	isOnGround = false;
		        if(contact.getFixtureB().getUserData() != null &&
		               contact.getFixtureB().getUserData().equals("playerFoot"))
		        	isOnGround = false;
	        }
	
			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub
				
			}
	    });
	}
	
	public void stateChange(float delta) {
		

		if (controller.left) {
//			body.applyLinearImpulse(new Vector2(-body.getMass() * 50 * delta , 0), body.getWorldCenter(), false);
//			body.applyLinearImpulse(new Vector2(-body.getMass()/2, 0), body.getWorldCenter(), false);
			body.setLinearVelocity(-30, body.getLinearVelocity().y);
		} 
		if (controller.right) {
//			body.applyLinearImpulse(new Vector2(body.getMass() * 50 * delta , 0), body.getWorldCenter(), false);

//			body.applyLinearImpulse(new Vector2(body.getMass()/2,0), body.getWorldCenter(), false);
//			body.getLinearVelocity().x = -100;
			body.setLinearVelocity(30, body.getLinearVelocity().y);
		}
		switch (state) {
			case STAND_STATE:
				if (controller.up==true) {
					body.getLinearVelocity().y += 5;
					body.applyLinearImpulse(new Vector2(0, body.getMass() * 20), body.getWorldCenter(), false);
					state = JUMP_STATE;
				}
				break;
//				if (dy < 0) {
//					state = FALL_STATE;
//					stateChange(delta);
//					break;
//				}
//				dx = 0;
//				if (controller.up == true) {
//					dy = Settings.jumpMoveSpeed;
//					state = JUMP_STATE;
//				} else if (controller.left) {
//					dx = -Settings.xButtonMoveSpeed;
//					state = RUN_LEFT_STATE;
//				} else if (controller.right) {
//					dx = Settings.xButtonMoveSpeed;
//					state = RUN_RIGHT_STATE;
//				}
//				break;
			case JUMP_STATE:
				if (isOnGround) {
//					justLanded = 0;
					state = STAND_STATE;
				}
				break;
//			case LANDING_STATE:
//				justLanded += delta;
//				if(justLanded >= .3) {
//					state = STAND_STATE;
//				}
//				break;
				
//				
//			case JUMP_RIGHT_STATE:
//				if (!controller.right) {
//					dx = 0;
//					state = JUMP_STATE;
//					stateChange(delta);
//					break;
//				}
//				if (dy <= 0) {
//					state = FALL_STATE;
//				}
//				break;
//			case JUMP_LEFT_STATE:
//				if (!controller.left) {
//					dx = 0;
//					state = JUMP_STATE;
//					stateChange(delta);
//					break;
//				}
//				if (dy <= 0) {
//					state = FALL_STATE;
//				}
//				break;
//			case FALL_STATE:
//				if (controller.right && controller.left);
//				else if (controller.right) {
//					dx = Settings.xButtonMoveSpeed;
//					state = FALL_RIGHT_STATE;
//				}
//				else if (controller.left) {
//					dx = -Settings.xButtonMoveSpeed;
//					state = FALL_LEFT_STATE;
//				}
//				if (dy == 0) {
//					state = STAND_STATE;
//				}
//				break;
//			case FALL_RIGHT_STATE:
//				if (!controller.right) {
//					dx = 0;
//					state = FALL_STATE;
//					stateChange(delta);
//					break;
//				}
//				if (dy == 0) {
//					state = STAND_STATE;
//				}
//				break;
//			case FALL_LEFT_STATE:
//				if (!controller.left) {
//					dx = 0;
//					state = FALL_STATE;
//					stateChange(delta);
//					break;
//				}
//				if (dy == 0) {
//					state = STAND_STATE;
//				}
//				break;
//			case RUN_RIGHT_STATE:
//				if (controller.up) {
//					dy = Settings.jumpMoveSpeed;
//					state = JUMP_RIGHT_STATE;
//				}
//				if (!controller.right) {
//					dx = 0;
//					state = STAND_STATE;
//				}
//				break;
//			case RUN_LEFT_STATE:
//				if (controller.up) {
//					dy = Settings.jumpMoveSpeed;
//					state = JUMP_LEFT_STATE;
//				}
//				if (!controller.left) {
//					dx = 0;
//					state = STAND_STATE;
//				}
//				break;
		}
	}
	
}
