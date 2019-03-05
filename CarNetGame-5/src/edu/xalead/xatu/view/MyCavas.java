package edu.xalead.xatu.view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import edu.xalead.xatu.model.CarNetGame;
import edu.xalead.xatu.model.MyModel;
import edu.xalead.xatu.model.Player;

public class MyCavas extends JPanel/* implements Observer*/{
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	private CarNetgameFrame topFrame = null;
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		topFrame = (CarNetgameFrame)this.getTopLevelAncestor();
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		g.drawString("窗体宽 = " + topFrame.getWidth() + " , 窗体高 = " + topFrame.getHeight() + " ,画布宽 = " + w + " , 画布高 = " + h, 20, 20);
		
		CarNetGame m = topFrame.getModel();
//		
		if(m != null) {
			//画游戏模型
			m.draw(g);
//			//画跑道
//			road.draw(g);
//			//画玩家		
////			g.drawString(m.getPlayers()[0].getName(), 100, 100);
//			for(int i = 0 ; i < m.getPlayers().length ; i++) {
//				Player player = m.getPlayers()[i];
//				if(player != null) {
////					g.drawString(player.getName(), player.getCar().getLeft(), player.getCar().getDistance());
//					player.draw(g);
//					//画车
////					g.drawRect(player.getCar().getLeft(),  player.getCar().getDistance(), player.getCar().getWidth(), player.getCar().getHeight());
//				}
//			}
//			
		}
	}
	/*@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}
	*/
}
