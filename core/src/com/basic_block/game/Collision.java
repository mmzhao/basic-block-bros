package com.basic_block.game;

public class Collision {

//	public final static int COLLIDED_RIGHT = 0;
//	public final static int COLLIDED_LEFT = 0;
//	public final static int COLLIDED_TOP = 0;
//	public final static int COLLIDED_BOTTOM = 0;
//
//	// for DynamicEntities and Entities, treat all as rectangles
//	public static boolean intersect(DynamicEntity d, Entity e) { // FIX YOU HAVE BE ONLY MAKE THE TOP SIDE OF A PLATFORM REAL, NOT JUST CHECK FOR UPWARDS MOVEMENT
//		if(e instanceof Platform && (d.getDY() >= 0 || d.getLastBounds().overlaps(e.getBounds()))){
//			// account for jumping up through platforms
//			return false;
//		}
//		else if(d.getBounds().overlaps(e.getBounds())){
//			// check if d intersects e
//			return true;
//		}
////		else if(false) {
////			// check if d movement intersects e
////			return true;
////		}
//		return false;
//	}
//	
//	// adjusts d to make sure it no longer overlaps with e
//	// returns 0 (right), 1 (left), 2 (top), 3 (bottom) depending on where collision occurs on d
//	// pass in dx and dy now so you can modify and still have old values
//	public static int fixIntersection(DynamicEntity d, float dx, float dy, Entity e, float delta) {
//		// corder for dynamic entity
//		float dCornerX = d.getLastBounds().x;
//		float dCornerY = d.getLastBounds().y;
//		
//		// get the corner leading the movement
//		if(d.getDX() >= 0) {
//			dCornerX += d.getWidth();
//		}
//		if(d.getDY() >= 0) {
//			dCornerY += d.getHeight();
//		}
//		
//		//adjust to find corner location before movement, unnecessary since i keep track of previous frame position
////		dCornerX -= delta * d.getDX();
////		dCornerY -= delta * d.getDY();
//		
//		// lines for static entity
//		float eLineX = e.getX();
//		float eLineY = e.getY();
//		
//		// adjust lines for dynamic entity movement
//		if(d.getDX() < 0) {
//			eLineX += e.getWidth();
//		}
//		if(d.getDY() < 0) {
//			eLineY += e.getHeight();
//		}
//		
//		// get time needed to intersect the corner to each line
//		float intersectTimeX = (eLineX - dCornerX) / d.getDX();
//		float intersectTimeY = (eLineY - dCornerY) / d.getDY();
//		
//		
//		
//		if(intersectTimeX < 0) {
//			// can't intersect in X direction, already past intersection point
//			return adjustY(d, dy, e);
//		}
//		else if(intersectTimeY < 0) {
//			// can't intersect in Y direction, already past intersection point
//			return adjustX(d, dx, e);
//		}
//		else if(intersectTimeX >= intersectTimeY) {
//			// intersects in Y dir first
//			return adjustY(d, dy, e);
//		}
//		else if(intersectTimeX < intersectTimeY) {
//			// intersects in X dir first
//			return adjustX(d, dx, e);
//		}
//		else{
//			// should be impossible unless d and e were already intersected
//			System.out.println("you screwed up");
//			return -1;
//		}
//		
//		
//	}
//	
//	// adjusts x position if collides in x direction
//	//returns 0 if collides on right side of d, returns 1 if collides on left side of d
//	private static int adjustX(DynamicEntity d, float dx, Entity e) {
//		d.setDX(0);
//		if(dx > 0) {
//			// going right, need to bump left, move right edge of d to left edge of e
//			d.setX(e.getX() - d.getWidth());
//			return COLLIDED_RIGHT;
//		}
//		else {
//			// going left, need to bump right, move left edge of d to right edge of e
//			d.setX(e.getX() + e.getWidth());
//			return COLLIDED_LEFT;
//		}
//	}
//	
//
//	// adjusts y position if collides in y direction
//	//returns 2 if collides on top side of d, returns 3 if collides on bottom side of d
//	private static int adjustY(DynamicEntity d, float dy, Entity e) {
//		d.setDY(0);
//		if(dy > 0) {
//			// going up, need to bump down, move top edge of d to bottom edge of e
//			d.setY(e.getY() - d.getHeight());
//			return COLLIDED_TOP;
//		}
//		else {
//			// going down, need to bump up, move bottom edge of d to top edge of e
//			d.setY(e.getY() + e.getHeight());
//			return COLLIDED_BOTTOM;
//		}
//	}
//	
//	public static boolean intersect(DynamicEntity d1, DynamicEntity d2) {
//		// assumes dynamic entities are circular, so width equals height
//		
//		// check pythag
//		if(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2) < Math.pow(d1.getWidth() / 2 + d2.getWidth() / 2, 2)) {
//			return true;
//		}
//		
//		return false;
//	}
	
	
	
}
