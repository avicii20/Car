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
		//�������Ѿ��������ҷ����¼�����Ϸ����ҵ�����ģ��
		serverSkel.addNewPlayer(new PlayerVO(newPlayer),clients);
		
		//�ѷ���������ģ�ͷ����¼���ͻ�
		CarNetGameVO vo = new CarNetGameVO(this);
		vo.setMajorIndex(majorIndex);
		//���¼�����ҷ���������Ϸ������ģ��
		serverSkel.join(vo,ip,port);
		clients.add(ip + ":" + port);
		
		
	}

	public void serverLR(int index, int left) {
		//�Ȱѿͻ��˷����������ƶ��ĳ��������޸Ĳ�ˢ��
		this.lr(index, left);
		//�ٰѿͻ��˷����������ƶ��ĳ������ݣ��ƶ��ĳ���������left���꣩���͸����пͻ�
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
		//�Ȱѿͻ��˷����������ƶ��ĳ��������޸Ĳ�ˢ��
		this.ud(index, distance);
		//�ٰѿͻ��˷����������ƶ��ĳ������ݣ��ƶ��ĳ���������distance���꣩���͸����пͻ�
		serverSkel.ud(index,distance,clients); 
	}

	

}
