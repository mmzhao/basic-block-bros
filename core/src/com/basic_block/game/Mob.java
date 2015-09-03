package com.basic_block.game;

import com.badlogic.gdx.Gdx;

public class Mob extends DynamicEntity {

	public Mob() {
		super();
		
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
		x = w/2 - 400;
		y = h/2;
		
		width = 100;
		height = 100;
		state = 0;
		
		dx = 0;
		dy = 0;
	}
	
}
