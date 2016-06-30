package com.juanpol.game.model;

import java.awt.Rectangle;

import com.juanpol.game.main.Resources;

public class Player {
	private float x,y;
	private int width,height,velY;
	private Rectangle rect, duckRect,ground,rect2;
	
	private boolean isAlive;
	private boolean isDucked;
	private float duckDuration = .6f;
	
	private static final int JUMP_VELOCITY = -650;
	private static final int ACCEL_GRAVITY = 1800;
	
	
	public Player(float x, float y, int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		ground = new Rectangle(0,405,800,1000);
		
		rect = new Rectangle();
		rect2 = new Rectangle();
		duckRect = new Rectangle();
		
		isAlive = true;
		isDucked = false;
		updateRects();
		
	}
	
	public void update(float delta){
		if(duckDuration > 0 && isDucked){
			duckDuration-= delta;
			
		}else {
			isDucked = false;
			duckDuration = .6f;
		}
		
		if(!isGrounded()){
			velY += ACCEL_GRAVITY * delta;
			System.out.println(velY);
		}else{
			y = 406 - height;
			velY =0; 
		}
		
		y+= velY * delta;
		updateRects();
	}
	
	public void updateRects(){
		rect.setBounds((int)x+10,(int)y +20, width - 20,height-20);
		
		rect2.setBounds((int)x+10,(int)y, width - 50,height);
		
		duckRect.setBounds((int)x, (int)y + 20, width, height - 20);
	}
	
	public void jump(){
		if (isGrounded()){
			Resources.onjump.play();
			isDucked = false;
			duckDuration = .6f;
			y-= 10;
			velY = JUMP_VELOCITY;
			updateRects();
		}
	}
	
	public void duck(){
		if(isGrounded()){
			isDucked = true;
		}
	}
	
	public void pushBack(int dX){
		Resources.hit.play();
		x -= dX;
		if(x < -width/2){
			isAlive = false;
		}
		rect.setBounds((int) x+10, (int) y+20 , width-20, height-20);
		rect2.setBounds((int)x+10,(int)y, width - 50,height);
	}
	
	public boolean isGrounded(){
		return rect.intersects(ground);
	}
	
	public boolean isDucked(){
		return isDucked;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public Rectangle getRect(){
		return rect;
	}
	
	public Rectangle getRect2(){
		return rect2;
	}
	
	public Rectangle getDuckRect() {
		return duckRect;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public float getDuckDuration(){
		return duckDuration;
	}

}
