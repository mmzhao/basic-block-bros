package com.basic_block.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Settings {

	// list of settings, aka magic numbers
	
	// width/height of game screen
	public static float screenWidth = 56;
    public static float screenHeight = 35;
    
    // width/height of computer screen
    public static float compWidth = Gdx.graphics.getWidth();;
    public static float compHeight = Gdx.graphics.getHeight();

    public static Texture img = new Texture("badlogic.jpg");
    
    
    //--------------------PLAYER SETTINGS--------------------//
    
    // speed when player moves right or left
    public static float xButtonMoveSpeed = 80;
    // speed set when player jumps
    public static float jumpMoveSpeed = 120;
    public static float playerWidth = 2;
    public static float playerHeight = 2;
    
  //--------------------MOB SETTINGS--------------------//


    public static float mobWidth = 2;
    public static float mobHeight = 2;
	
}
