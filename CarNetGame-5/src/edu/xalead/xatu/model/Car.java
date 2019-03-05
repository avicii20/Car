package edu.xalead.xatu.model;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.xalead.xatu.view.MyCavas;
import edu.xalead.xatu.vo.CarVO;

public class Car extends RoadThing {
	private int speed;
	private int blood;
	private int acceleration;
	private int topSpeed;
	private BufferedImage carImage = null;
	private Player player;
	public Car(Player player) {
		super(player.getIndex(),0,0,135,150,player.getGame().getRoad());
		try {
			init();
			
			this.player = player;
			this.speed = 10;
			this.blood = 100;
			this.acceleration = 1;
			this.topSpeed = 20;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		carImage = ImageIO.read(Thread
				.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("edu/xalead/xatu/model/paoche.png"));
	}
	public Car(CarVO carvo, Player player) {
		super(carvo.getId(),carvo.getDistance(),carvo.getLeft(),carvo.getWidth(),carvo.getHeight(),player.getGame().getRoad());
		try {
			init();
			this.player = player;
			this.acceleration = carvo.getAcceleration();
			this.speed = carvo.getSpeed();
			this.topSpeed = carvo.getTopSpeed();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void draw(Graphics g) {
		int ac = 0;
		if(this.getRoad() != null) {
			ac = this.getRoad().getAc();
		}
		g.drawImage(carImage, Road.ROAD_LEFT + getLeft(), MyCavas.GAME_HEIGHT - (getDistance() - ac) - getHeight(),getWidth(),getHeight(), null);
	}
	public void left() {
		super.left(this.getSpeed());
	}
	public void right() {
		super.right(this.getSpeed());
	}
	public void up() {
		super.up(this.getSpeed());
	}
	public void down() {
		super.down(this.getSpeed());
	}
}
