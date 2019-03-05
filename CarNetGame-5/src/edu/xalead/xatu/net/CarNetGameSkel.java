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
			//��voת����json
			GamePackage gp = new GamePackage();
			gp.setGameVo(vo);
			gp.setType("create");
			String jsonstr = JSONUtil.toJson(gp);
			
			//�����ʰ�
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
	 * ���������Ѿ�������ҷ�����������ݵķ���
	 * @param playerVO
	 * @param clients 
	 */
	public void addNewPlayer(PlayerVO playerVO, ArrayList<String> clients) {
		try {
			//��voת����json
			GamePackage gp = new GamePackage();
			gp.setPlayerVO(playerVO);
			gp.setType("addplayer");
			String jsonstr = JSONUtil.toJson(gp);
			
			//�������Ѽ�����Ϸ�Ŀͻ��˷�����������ݣ���Ҫ�����Ѽ�����ҵ�ַ�Ͷ˿�
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//�����ʰ�
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
			//��voת����json
			GamePackage gp = new GamePackage();
			gp.setType("lr");
			gp.setIndex(index);
			gp.setLeft(left);
			String jsonstr = JSONUtil.toJson(gp);
			
			//�������Ѽ�����Ϸ�Ŀͻ��˷�����������ݣ���Ҫ�����Ѽ�����ҵ�ַ�Ͷ˿�
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//�����ʰ�
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
			//��voת����json
			GamePackage gp = new GamePackage();
			gp.setType("ud");
			gp.setIndex(index);
			gp.setDistance(distance);
			String jsonstr = JSONUtil.toJson(gp);
			
			//�������Ѽ�����Ϸ�Ŀͻ��˷�����������ݣ���Ҫ�����Ѽ�����ҵ�ַ�Ͷ˿�
			if(clients != null) {
				for(String adr : clients) {
					String ip = adr.split(":")[0];
					int port = Integer.parseInt(adr.split(":")[1]);
					//�����ʰ�
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
