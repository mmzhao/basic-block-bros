package com.basic_block.game;

public class Pickup extends DynamicEntity{
	
	public Pickup() {
		
		x = 500;
		y = 500;
		
		width = 50;
		height = 50;
		
		setBounds();
		
		ay = 0;
	}
	
	public Pickup(float tileOffset) {
		
		x = 500 + tileOffset;
		y = 500;
		
		width = 50;
		height = 50;
		
		setBounds();
		
		ay = 0;
	}
	
}
