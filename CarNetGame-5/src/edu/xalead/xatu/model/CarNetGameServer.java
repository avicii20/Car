package edu.xalead.xatu.model;

import java.util.ArrayList;

import edu.xalead.xatu.net.CarNetGameSkel;
import edu.xalead.xatu.net.ServerMonitor;
import edu.xalead.xatu.vo.CarNetGameVO;
import edu.xalead.xatu.vo.PlayerVO;

public class CarNetGameServer extends CarNetGame {
	private ArrayList<String> clients = new ArrayList<String>();
	private CarNetGameSkel serverSkel = null;
	public CarNetGameServer(String palyerName, int length) {
//		this.getPlayers()[0] = new Player(palyerName,this);
		serverSkel = new CarNetGameSkel();
		this.setRoad(new Road(length,this));
		this.setMajor(new Player(palyerName,this));
		this.addPlayer(this.getMajor());
		
//		
		new ServerMonitor(this).start();
	}

	public void join(String playerName,String ip,int port) {
		Player newPlayer = new Player(playerName, this);
		int majorIndex = this.addPlayer(newPlayer);
		this.getCanvas().repaint();
		//给其它已经加入的玩家发送新加入游戏的玩家的数据模型
		serverSkel.addNewPlayer(new PlayerVO(newPlayer),clients);
		
		//把服务器整个模型发给新加入客户
		CarNetGameVO vo = new CarNetGameVO(this);
		vo.setMajorIndex(majorIndex);
		//给新加入玩家发送整个游戏的数据模型
		serverSkel.join(vo,ip,port);
		clients.add(ip + ":" + port);
		
		
	}

	public void serverLR(int index, int left) {
		//先把客户端发送上来的移动的车的数据修改并刷新
		this.lr(index, left);
		//再把客户端发送上来的移动的车的数据（移动的车的索引和left坐标）发送给所有客户
		serverSkel.lr(index,left,clients);
	}

	public ArrayList<String> getClients() {
		return clients;
	}

	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
	}

	public CarNetGameSkel getServerSkel() {
		return serverSkel;
	}

	public void setServerSkel(CarNetGameSkel serverSkel) {
		this.serverSkel = serverSkel;
	}

	public void serverUD(int index, int distance) {
		//先把客户端发送上来的移动的车的数据修改并刷新
		this.ud(index, distance);
		//再把客户端发送上来的移动的车的数据（移动的车的索引和distance坐标）发送给所有客户
		serverSkel.ud(index,distance,clients); 
	}

	

}
