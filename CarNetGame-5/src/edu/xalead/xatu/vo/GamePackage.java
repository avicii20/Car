package edu.xalead.xatu.vo;

public class GamePackage {
	private String name;//��һ�μ�����Ϸ��Ҫ�����û���
	private int port;//�ͻ��˵Ķ˿�
	private String type ;//���룬���������ƣ����ƣ�
	private CarNetGameVO gameVo;
	private int left;
	private int index;
	private int distance;
	private PlayerVO playerVO;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CarNetGameVO getGameVo() {
		return gameVo;
	}
	public void setGameVo(CarNetGameVO gameVo) {
		this.gameVo = gameVo;
	}
	public PlayerVO getPlayerVO() {
		return playerVO;
	}
	public void setPlayerVO(PlayerVO playerVO) {
		this.playerVO = playerVO;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	} 
}
