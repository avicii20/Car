package edu.xalead.xatu.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import edu.xalead.xatu.util.JSONUtil;
import edu.xalead.xatu.vo.CarNetGameVO;
import edu.xalead.xatu.vo.GamePackage;
import edu.xalead.xatu.vo.PlayerVO;

public class CarNetGameSkel {
	private DatagramSocket ds = null;
	
	public CarNetGameSkel() {
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void join(CarNetGameVO vo,String ip,int port) {
		try {
			//把vo转换成json
			GamePackage gp = new GamePackage();
			gp.setGameVo(vo);
			gp.setType("create");
			String jsonstr = JSONUtil.toJson(gp);
			
			//创建邮包
			DatagramPacket packet = new DatagramPacket(
											jsonstr.getBytes(), 
											jsonstr.getBytes().length,
											InetAddress.getByName(ip),
											port);
			
			ds.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 服务器给已经加入玩家发送新玩家数据的方法
	 * @param playerVO
	 * @param clients 
	 */
	public void addNewPlayer(PlayerVO playerVO, ArrayList<String> clients) {
		try {
			//把vo转换成json
			GamePackage gp = new GamePackage();
			gp.setPlayerVO(playerVO);
			gp.setType("addplayer");
			String jsonstr = JSONUtil.toJson(gp);
			
			//给所有已加入游戏的客户端发送新玩家数据，需要所有已加入玩家地址和端口
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//创建邮包
					DatagramPacket packet = new DatagramPacket(
													jsonstr.getBytes(), 
													jsonstr.getBytes().length,
													InetAddress.getByName(ip),
													port);
					ds.send(packet);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void lr(int index, int left, ArrayList<String> clients) {
		try {
			//把vo转换成json
			GamePackage gp = new GamePackage();
			gp.setType("lr");
			gp.setIndex(index);
			gp.setLeft(left);
			String jsonstr = JSONUtil.toJson(gp);
			
			//给所有已加入游戏的客户端发送新玩家数据，需要所有已加入玩家地址和端口
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//创建邮包
					DatagramPacket packet = new DatagramPacket(
													jsonstr.getBytes(), 
													jsonstr.getBytes().length,
													InetAddress.getByName(ip),
													port);
					ds.send(packet);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void ud(int index, int distance, ArrayList<String> clients) {
		try {
			//把vo转换成json
			GamePackage gp = new GamePackage();
			gp.setType("ud");
			gp.setIndex(index);
			gp.setDistance(distance);
			String jsonstr = JSONUtil.toJson(gp);
			
			//给所有已加入游戏的客户端发送新玩家数据，需要所有已加入玩家地址和端口
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//创建邮包
					DatagramPacket packet = new DatagramPacket(
													jsonstr.getBytes(), 
													jsonstr.getBytes().length,
													InetAddress.getByName(ip),
													port);
					ds.send(packet);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
