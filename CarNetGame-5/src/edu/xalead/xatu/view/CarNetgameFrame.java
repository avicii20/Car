package edu.xalead.xatu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.xalead.xatu.model.CarNetGame;
import edu.xalead.xatu.model.CarNetGameServer;
import edu.xalead.xatu.model.MyModel;

public class CarNetgameFrame extends JFrame {
	private JMenu menu = new JMenu("游戏");
	private JMenuItem menuItem = new JMenuItem("创建或加入游戏");
	private MyCavas cavas = new MyCavas();
	private CarNetGame model = null;
	public CarNetgameFrame() {
		super("网络飞车");
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		bar.add(menu);
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//显示对话框
				new CreateOrJoinDialog(CarNetgameFrame.this);
			}
		});
		
//		model.addObserver(cavas);//给模型注册观察者
		this.addKeyListener(
					new KeyAdapter() {
						
						@Override
						public void keyPressed(KeyEvent e) {
//							System.out.println(e.getKeyCode());
							switch (e.getKeyCode()) {
							case KeyEvent.VK_LEFT:
								model.left();
								break;

							case KeyEvent.VK_RIGHT:
//								
								model.right();
								
								break;
							case KeyEvent.VK_UP:
								model.up();
								break;
							case KeyEvent.VK_DOWN:
								model.down();
								break;
							}
							cavas.repaint();
						}
						
					}
				);
		
		this.add(cavas);
		this.setSize(806,654);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
	}
//	public MyModel getModel() {
//		return model;
//	}
	public CarNetGame getModel() {
		return model;
	}
	public void setModel(CarNetGame model) {
		this.model = model;
	}
	public MyCavas getCavas() {
		return cavas;
	}
}
