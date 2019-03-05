package edu.xalead.xatu.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import edu.xalead.xatu.util.JSONUtil;
import edu.xalead.xatu.vo.GamePackage;

public class CarNetGameStub {
	private String ip;
	private DatagramSocket ds = null;
	private int port = 8888;

	public CarNetGameStub() {
		for (;;) {
			try {
				ds = new DatagramSocket(port);
				break;
			} catch (SocketException e) {
				port++;
			}
		}
	}

	/**
	 * 第一次加入游戏时调用 的方法
	 * 
	 * @param palyerName
	 * @param ip
	 */
	public void join(String palyerName, String ip) {
		try {
			this.ip = ip;
			// 准备vo
			GamePackage gp = new GamePackage();
			gp.setType("join");
			gp.setName(palyerName);
			// 转成json串
			String jsonString = JSONUtil.toJson(gp);
			// 发送
			DatagramPacket packet = new DatagramPacket(jsonString.getBytes(), jsonString.getBytes().length,
					InetAddress.getByName(ip), 9999);
			ds.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lr(int left, int index) {
		try {
			// 准备vo
			GamePackage gp = new GamePackage();
			gp.setType("lr");
			gp.setLeft(left);
			gp.setIndex(index);
			// 转成json串
			String jsonString = JSONUtil.toJson(gp);
			DatagramPacket packet = new DatagramPacket(jsonString.getBytes(), jsonString.getBytes().length,
					InetAddress.getByName(ip), 9999);
			ds.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ud(int distance, int index) {
		try {
			// 准备vo
			GamePackage gp = new GamePackage();
			gp.setType("ud");
			gp.setDistance(distance);
			gp.setIndex(index);
			// 转成json串
			String jsonString = JSONUtil.toJson(gp);
			DatagramPacket packet = new DatagramPacket(jsonString.getBytes(), jsonString.getBytes().length,
					InetAddress.getByName(ip), 9999);
			ds.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}

}
