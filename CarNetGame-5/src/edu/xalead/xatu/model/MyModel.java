package edu.xalead.xatu.model;

import java.util.Observable;

public class MyModel extends Observable{
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	
	public MyModel() {
		x = 0;
		y = 0;
		width = 115;
		height = 150;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

//	private void notifyOb() {
//		this.setChanged();
//		this.notifyObservers();
//	}
	
	public void left() {
		this.x -= 10;
		
//		this.notifyOb();
	}

	public void right() {
		this.x += 10;
//		this.notifyOb();
	}

	public void up() {
		this.y -= 10;
//		this.notifyOb();
	}

	public void down() {
		this.y += 10;
//		this.notifyOb();
	}
}
