package edu.xalead.xatu.model;

import java.awt.Graphics;

import edu.xalead.xatu.view.MyCavas;

public abstract class CarNetGame {
	private MyCavas canvas = null;
	private String status;
	private Road road;
	private Player[] players = new Player[5];
	private Player major;
	/**
	 * 获得当前游戏模型中主控制玩家的模型索引
	 * @return
	 */
	public int getMajorIndex() {
		for(int i = 0 ; i < players.length ; i++) {
			if(players[i] == major) {
				return i;
			}
		}
		return -1;
	}
	public int addPlayer(Player p) {
		
		for(int i = 0 ; i < players.length ;i++) {
			if(players[i] == null) {
				p.setIndex(i);
				p.getCar().setLeft(i * 100);
				players[i] = p;
				return i;
			}
		}
		if(p.getIndex() == -1) {
			throw new RuntimeException("玩家数量已满！不能加入！");
		}
		return -1;
	}
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}
	public void draw(Graphics g) {
		//画跑道
		road.draw(g);
		//画玩家
		for(int i = 0 ; i < players.length ; i++) {
			Player player = players[i];
			if(player != null) {
				player.draw(g);
			}
		}
	}
	public void left() {
		this.major.left();
	}
	public Player getMajor() {
		return major;
	}
	public void setMajor(Player major) {
		this.major = major;
	}
	public void right() {
		this.major.right();
	}
	public void up() {
		this.major.up();
	}
	public void down() {
		this.major.down();
	}
	public void setCanvas(MyCavas canvas) {
		this.canvas = canvas;
	}
	public MyCavas getCanvas() {
		return canvas;
	}
	
	public void lr(int index,int left) {
		this.players[index].getCar().setLeft(left);
		if(getCanvas() != null)
			getCanvas().repaint();
	}
	public void ud(int index,int distance) {
		this.players[index].getCar().setDistance(distance);
		if(getCanvas() != null)
			getCanvas().repaint();
	}
}
