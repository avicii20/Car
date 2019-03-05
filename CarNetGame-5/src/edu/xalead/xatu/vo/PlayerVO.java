package edu.xalead.xatu.vo;

import edu.xalead.xatu.model.Player;

public class PlayerVO {
	private String name;
	private CarVO carvo;
	public PlayerVO() {}
	public PlayerVO(Player player) {
		this.name = player.getName();
		this.carvo = new CarVO(player.getCar());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CarVO getCarvo() {
		return carvo;
	}
	public void setCarvo(CarVO carvo) {
		this.carvo = carvo;
	}
}
