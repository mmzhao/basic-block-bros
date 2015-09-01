package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player extends DynamicEntity{
	
	public Player() {
		
		super();

		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
		x = w/2;
		y = h/2;
		
		width = 100;
		height = 100;
		state = 0;
		
		dx = 0;
		dy = 0;
	}
	
}
