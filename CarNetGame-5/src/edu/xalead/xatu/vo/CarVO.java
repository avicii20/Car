package edu.xalead.xatu.vo;

import edu.xalead.xatu.model.Car;

public class CarVO extends RoadThingsVO{
	private int speed;
	private int blood;
	private int acceleration;
	private int topSpeed;
	public CarVO() {}
	public CarVO(Car car) {
		this.setWidth(car.getWidth());
		this.setHeight(car.getHeight());
		this.setBlood(car.getBlood());
		this.setAcceleration(car.getAcceleration());
		this.setDistance(car.getDistance());
		this.setLeft(car.getLeft());
		this.setId(car.getId());
		this.setSpeed(car.getSpeed());
		this.setTopSpeed(car.getTopSpeed());
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}
	public int getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
}
