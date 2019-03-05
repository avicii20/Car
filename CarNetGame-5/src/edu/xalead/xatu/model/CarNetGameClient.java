package edu.xalead.xatu.model;

import edu.xalead.xatu.net.CarNetGameStub;
import edu.xalead.xatu.net.ClientMonitor;
import edu.xalead.xatu.view.MyCavas;
import edu.xalead.xatu.vo.CarNetGameVO;
import edu.xalead.xatu.vo.PlayerVO;

public class CarNetGameClient extends CarNetGame {
	
	//客户端模型持有客户端代理引用
	private CarNetGameStub stub = new CarNetGameStub();
	public CarNetGameClient(String palyerName, String ip) {
		new ClientMonitor(stub.getDs(),this).start();
		stub.join(palyerName,ip);
	}
	public void create(CarNetGameVO gameVo) {
		this.setStatus(gameVo.getStatus());
		this.setRoad(new Road(gameVo.getRoad(),this));
		PlayerVO[] players = gameVo.getPlayer();
		for(int i = 0 ; i < players.length ; i++) {
			if(players[i] != null) {
				this.getPlayers()[i] = new Player(players[i],this);
			}
		}
		MyCavas canvas = this.getCanvas();
		canvas.repaint();
	}
	public void addJoinPlayer(PlayerVO playerVO) {
		this.addPlayer(new Player(playerVO, this));
		MyCavas canvas = this.getCanvas();
		canvas.repaint();
	}
	public CarNetGameStub getStub() {
		return stub;
	}
	public void clientLR(int index, int left) {
		this.lr(index, left);
		
	}
	public void clientUD(int index, int distance) {
		this.ud(index, distance);
	}

}
