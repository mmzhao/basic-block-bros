package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
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
	
	int state;
	
	public Player(MController controller, com.badlogic.gdx.physics.box2d.World world) {

		this.controller = controller;
        
		x = Settings.screenWidth/2;
		y = Settings.screenHeight/2;
		
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
        fixtureDef.density = 1f;
        
        fixture = body.createFixture(fixtureDef);
        
        shape.dispose();
	}
	
//	public void stateChange(float delta) {
//		switch (state) {
//			case STAND_STATE:
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
//			case JUMP_STATE:
//				
//				if (controller.right && controller.left);
//				else if (controller.right) {
//					dx = Settings.xButtonMoveSpeed;
//					state = JUMP_RIGHT_STATE;
//				}
//				else if (controller.left) {
//					dx = -Settings.xButtonMoveSpeed;
//					state = JUMP_LEFT_STATE;
//				}
//				
//				if (dy <= 0) {
//					state = FALL_STATE;
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
//		}
//	}
	
}
