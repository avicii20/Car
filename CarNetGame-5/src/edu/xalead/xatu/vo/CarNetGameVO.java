package edu.xalead.xatu.vo;

import edu.xalead.xatu.model.CarNetGame;
import edu.xalead.xatu.model.Player;

public class CarNetGameVO {
	private String status;
	private RoadVO road;
	private PlayerVO[] player = new PlayerVO[5];
	private int majorIndex;
	
	public CarNetGameVO() {
		
	}
	public CarNetGameVO(CarNetGame carNetGame) {
		this.status = carNetGame.getStatus();
		this.road = new RoadVO(carNetGame.getRoad());
		Player[] players = carNetGame.getPlayers();
		for(int i = 0 ; i < players.length ; i++) {
			if(players[i] != null) {
				player[i] = new PlayerVO(players[i]);
			}
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RoadVO getRoad() {
		return road;
	}
	public void setRoad(RoadVO road) {
		this.road = road;
	}
	public PlayerVO[] getPlayer() {
		return player;
	}
	public void setPlayer(PlayerVO[] player) {
		this.player = player;
	}
	public int getMajorIndex() {
		return majorIndex;
	}
	public void setMajorIndex(int majorIndex) {
		this.majorIndex = majorIndex;
	}
	
}
