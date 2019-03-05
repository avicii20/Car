package edu.xalead.xatu.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import edu.xalead.xatu.model.CarNetGameServer;
import edu.xalead.xatu.model.Player;
import edu.xalead.xatu.util.JSONUtil;
import edu.xalead.xatu.vo.GamePackage;

public class ServerMonitor extends Thread{
	private DatagramSocket ds = null;
	private CarNetGameServer game;
	public ServerMonitor(CarNetGameServer carNetGameServer) {
		try {
			this.game = carNetGameServer;
			ds = new DatagramSocket(9999);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			while(true) {
				DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
				ds.receive(packet);//接收数据
				String jsonStr = new String(packet.getData(),0,packet.getLength());
				
				GamePackage pkg = (GamePackage)JSONUtil.toJava(jsonStr);
				switch (pkg.getType()) {
				case "join":
					String playerName = pkg.getName();
					game.join(playerName,packet.getAddress().getHostName(),packet.getPort());
					break;

				case "lr":
					int left = pkg.getLeft();
					int index = pkg.getIndex();
					game.serverLR(index, left);
					
					break;
				case "ud":
					int distance = pkg.getDistance();
					index = pkg.getIndex();
					game.serverUD(index, distance);
					
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
