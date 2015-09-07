package com.basic_block.game;

public class Player extends DynamicEntity{
	
	public Player() {
		
		super();
        
		x = Settings.screenWidth/2;
		y = Settings.screenHeight/2;
		
		width = Settings.playerWidth;
		height = Settings.playerHeight;
		
		setBounds();
		
		state = 0;
		
		dx = 0;
		dy = 0;
	}
	
}
