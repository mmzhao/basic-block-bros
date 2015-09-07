package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Settings {

	// list of settings, aka magic numbers
	public static float screenWidth = Gdx.graphics.getWidth();
    public static float screenHeight = Gdx.graphics.getHeight();

    public static Texture img = new Texture("badlogic.jpg");
    
    public static float gravity = -5000;
    
    
    //--------------------PLAYER SETTINGS--------------------//
    
    // speed when player moves right or left
    public static float xButtonMoveSpeed = 500;
    // speed set when player jumps
    public static float jumpMoveSpeed = 1000;
    public static float playerWidth = 100;
    public static float playerHeight = 100;
    
  //--------------------MOB SETTINGS--------------------//


    public static float mobWidth = 100;
    public static float mobHeight = 100;
	
}
