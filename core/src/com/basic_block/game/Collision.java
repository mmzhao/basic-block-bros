package com.basic_block.game;

public class Collision {

	// for DynamicEntities and Entities, treat all as rectangles
	public static boolean intersect(DynamicEntity d, Entity e) {
		if(d.getBounds().overlaps(e.getBounds())){
			// check if d intersects e
			return true;
		}
		else if(false) {
			// check if d movement intersects e
			return true;
		}
		return false;
	}
	
	
	public static void fixIntersection(DynamicEntity d, Entity e, float delta) {
		// corder for dynamic entity
		float dCornerX = d.getX();
		float dCornerY = d.getY();
		
		// get the corner leading the movement
		if(d.getDX() >= 0) {
			dCornerX += d.getWidth();
		}
		if(d.getDY() >= 0) {
			dCornerY += d.getHeight();
		}
		
		//adjust to find corner location before movement
		dCornerX -= delta * d.getDX();
		dCornerY -= delta * d.getDY();
		
		// lines for static entity
		float eLineX = e.getX();
		float eLineY = e.getY();
		
		// adjust lines for dynamic entity movement
		if(d.getDX() < 0) {
			eLineX += e.getWidth();
		}
		if(d.getDY() < 0) {
			eLineY += e.getHeight();
		}
		
		// get time needed to intersect the corner to each line
		float intersectTimeX = (eLineX - dCornerX) / d.getDX();
		float intersectTimeY = (eLineY - dCornerY) / d.getDY();
		
		if(intersectTimeX < 0) {
			// can't intersect in X direction, already past intersection point
			adjustY(d, e);
		}
		else if(intersectTimeY < 0) {
			// can't intersect in Y direction, already past intersection point
			adjustX(d, e);
		}
		else if(intersectTimeX >= intersectTimeY) {
			// intersects in Y dir first
			adjustY(d, e);
		}
		else if(intersectTimeX < intersectTimeY) {
			// intersects in X dir first
			adjustX(d, e);
		}
		else{
			// should be impossible unless d and e were already intersected
			System.out.println("you screwed up");
		}
		
		
	}
	
	private static void adjustX(DynamicEntity d, Entity e) {
		if(d.getDX() > 0) {
			// going right, need to bump left, move right edge of d to left edge of e
			d.setX(e.getX() - d.getWidth());
		}
		else {
			// going left, need to bump right, move left edge of d to right edge of e
			d.setX(e.getX() + e.getWidth());
		}
		d.setDX(0);
	}
	
	private static void adjustY(DynamicEntity d, Entity e) {
		if(d.getDY() > 0) {
			// going up, need to bump down, move top edge of d to bottom edge of e
			d.setY(e.getY() - d.getHeight());
		}
		else {
			// going down, need to bump up, move bottom edge of d to top edge of e
			d.setY(e.getY() + e.getHeight());
		}
		d.setDY(0);
	}
	
	public static boolean intersect(DynamicEntity d1, DynamicEntity d2) {
		// assumes dynamic entities are circular, so width equals height
		
		// check pythag
		if(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() + d2.getY(), 2) < Math.pow(d1.getWidth() / 2 + d2.getWidth() / 2, 2)) {
			return true;
		}
		
		return false;
	}
	
	
	
}
