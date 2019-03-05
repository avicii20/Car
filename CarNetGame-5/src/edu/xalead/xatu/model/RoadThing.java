package edu.xalead.xatu.model;

import java.awt.Canvas;

import edu.xalead.xatu.view.MyCavas;

public abstract class RoadThing {
	private int id;
	private int distance;
	private int left;
	private int width;
	private int height;
	private Road road;
	public RoadThing(int id, int distance, int left, int width, int height,Road road) {
		super();
		this.road = road;
		this.id = id;
		this.distance = distance;
		this.left = left;
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
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
	public Road getRoad() {
		return road;
	}
	public void setRoad(Road road) {
		this.road = road;
	}

	public void left(int speed) {
		if(this.left > 0 ) {
			this.left -= speed;
			if(this.getRoad().getGame() instanceof CarNetGameClient) {
				((CarNetGameClient)this.getRoad().getGame()).getStub().lr(this.left,this.getRoad().getGame().getMajorIndex());
			}else {
				((CarNetGameServer)this.getRoad().getGame()).getServerSkel().lr(this.getRoad().getGame().getMajorIndex(), left, ((CarNetGameServer)this.getRoad().getGame()).getClients());
			}
		}
	}

	public void right(int speed) {
		if(this.left < MyCavas.GAME_WIDTH - Road.ROAD_LEFT * 2 - this.width) {
			this.left += speed;
			if(this.getRoad().getGame() instanceof CarNetGameClient) {
				((CarNetGameClient)this.getRoad().getGame()).getStub().lr(this.left,this.getRoad().getGame().getMajorIndex());
			}else {
				((CarNetGameServer)this.getRoad().getGame()).getServerSkel().lr(this.getRoad().getGame().getMajorIndex(), left, ((CarNetGameServer)this.getRoad().getGame()).getClients());
			}
		}
	}

	public void up(int speed) {
		if(this.distance > 300) {
			this.getRoad().setAc(this.getRoad().getAc() + speed);
		}
		this.distance += speed;
		
		if(this.getRoad().getGame() instanceof CarNetGameClient) {
			((CarNetGameClient)this.getRoad().getGame()).getStub().ud(this.distance,this.getRoad().getGame().getMajorIndex());
		}else {
			((CarNetGameServer)this.getRoad().getGame()).getServerSkel().ud(this.getRoad().getGame().getMajorIndex(), distance, ((CarNetGameServer)this.getRoad().getGame()).getClients());
		}
	}

	public void down(int speed) {
		if(this.distance > 300) {
			this.getRoad().setAc(this.getRoad().getAc() - speed);
		}
		if(this.distance > 0)
			this.distance -= speed;
	}
}
