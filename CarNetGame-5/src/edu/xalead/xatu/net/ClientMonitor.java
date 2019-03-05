package edu.xalead.xatu.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import edu.xalead.xatu.model.CarNetGameClient;
import edu.xalead.xatu.model.Player;
import edu.xalead.xatu.util.JSONUtil;
import edu.xalead.xatu.vo.GamePackage;

public class ClientMonitor extends Thread{
	private DatagramSocket ds = null;
	private CarNetGameClient carNetGame;
	public ClientMonitor(DatagramSocket ds,CarNetGameClient carNetGame) {
		this.ds = ds;
		this.carNetGame = carNetGame;
	}
	public void run() {
		try {
			while(true) {
				DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
				ds.receive(packet);
				
				//还原json串
				String jsonstr = new String(packet.getData(),0,packet.getLength());
				
				//根据jsonstr还原vo对象
				GamePackage pg = (GamePackage)JSONUtil.toJava(jsonstr);
				
				//判断类型
				switch (pg.getType()) {
				case "create":
					carNetGame.create(pg.getGameVo());
					carNetGame.setMajor(carNetGame.getPlayers()[pg.getGameVo().getMajorIndex()]);
					break;

				case "addplayer":
					carNetGame.addJoinPlayer(pg.getPlayerVO());
					break;
				case "lr":
					carNetGame.clientLR(pg.getIndex(),pg.getLeft());
					break;
				case "ud":
					carNetGame.clientUD(pg.getIndex(),pg.getDistance());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
