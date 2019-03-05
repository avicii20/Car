package edu.xalead.xatu.model;

import java.awt.Graphics;

import edu.xalead.xatu.vo.PlayerVO;

public class Player {
	private CarNetGame game;
	private String name;
	private int exp;
	private int index = -1;
	private Car car;
	public Player(String palyerName,CarNetGame game) {
		this.name = palyerName;
		this.game = game;
		this.car = new Car(this);
	}
	public Player(PlayerVO playerVO, CarNetGame game) {
		this.name = playerVO.getName();
		this.game = game;
		this.car = new Car(playerVO.getCarvo(),this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public CarNetGame getGame() {
		return game;
	}
	public void setGame(CarNetGame game) {
		this.game = game;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void draw(Graphics g) {
		g.drawString(this.name,this.car.getLeft(),this.car.getDistance() - 50);
		car.draw(g);
	}
	public void left() {
		car.left();
	}
	public void right() {
		car.right();
	}
	public void up() {
		car.up();
	}
	public void down() {
		car.down();
	}
}
