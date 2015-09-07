package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

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
	
	public Player(MController controller) {
		
		super();

		this.controller = controller;
		
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
		x = w/2;
		y = h/2;
		
		width = 100;
		height = 100;
		state = 0;
		
		dx = 0;
		dy = 0;
		
		state = STAND_STATE;
	}
	
	public void stateChange(float delta) {
		switch (state) {
			case STAND_STATE:
				if (dy < 0) {
					state = FALL_STATE;
					stateChange(delta);
					break;
				}
				dx = 0;
				if (controller.up == true) {
					dy = 500;
					state = JUMP_STATE;
				} else if (controller.left) {
					dx = -500;
					state = RUN_LEFT_STATE;
				} else if (controller.right) {
					dx = 500;
					state = RUN_RIGHT_STATE;
				}
				break;
			case JUMP_STATE:
				
				if (controller.right && controller.left);
				else if (controller.right) {
					dx = 500;
					state = JUMP_RIGHT_STATE;
				}
				else if (controller.left) {
					dx = -500;
					state = JUMP_LEFT_STATE;
				}
				
				if (dy <= 0) {
					state = FALL_STATE;
				}
				break;
				
			case JUMP_RIGHT_STATE:
				if (!controller.right) {
					dx = 0;
					state = JUMP_STATE;
					stateChange(delta);
					break;
				}
				if (dy <= 0) {
					state = FALL_STATE;
				}
				break;
			case JUMP_LEFT_STATE:
				if (!controller.left) {
					dx = 0;
					state = JUMP_STATE;
					stateChange(delta);
					break;
				}
				if (dy <= 0) {
					state = FALL_STATE;
				}
				break;
			case FALL_STATE:
				if (controller.right && controller.left);
				else if (controller.right) {
					dx = 500;
					state = FALL_RIGHT_STATE;
				}
				else if (controller.left) {
					dx = -500;
					state = FALL_LEFT_STATE;
				}
				if (dy == 0) {
					state = STAND_STATE;
				}
				break;
			case FALL_RIGHT_STATE:
				if (!controller.right) {
					dx = 0;
					state = FALL_STATE;
					stateChange(delta);
					break;
				}
				if (dy == 0) {
					state = STAND_STATE;
				}
				break;
			case FALL_LEFT_STATE:
				if (!controller.left) {
					dx = 0;
					state = FALL_STATE;
					stateChange(delta);
					break;
				}
				if (dy == 0) {
					state = STAND_STATE;
				}
				break;
			case RUN_RIGHT_STATE:
				if (controller.up) {
					dy = 500;
					state = JUMP_RIGHT_STATE;
				}
				if (!controller.right) {
					dx = 0;
					state = STAND_STATE;
				}
				break;
			case RUN_LEFT_STATE:
				if (controller.up) {
					dy = 500;
					state = JUMP_LEFT_STATE;
				}
				if (!controller.left) {
					dx = 0;
					state = STAND_STATE;
				}
				break;
		}
	}
	
}
