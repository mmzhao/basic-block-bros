package com.basic_block.game;

public class MController {
	boolean up, down, right, left;
	
	public MController() {
		reset();
	}
	
	public void reset() {
		up = false;
		down = false;
		right = false;
		left = false;
	}
}
