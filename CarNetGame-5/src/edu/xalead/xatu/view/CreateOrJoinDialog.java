package edu.xalead.xatu.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.xalead.xatu.model.CarNetGame;
import edu.xalead.xatu.model.CarNetGameClient;
import edu.xalead.xatu.model.CarNetGameServer;

public class CreateOrJoinDialog extends JDialog {
	private JTextField txtName = new JTextField(20);
	private JLabel lblName = new JLabel("玩家姓名");
	private JPanel panel1 = new JPanel();
	{
		panel1.add(lblName);
		panel1.add(txtName);
	}
	
	private JCheckBox chkSer = new JCheckBox();
	private JLabel lblSer = new JLabel("是否做为服务器");
	private JPanel panel2 = new JPanel();
	{
		panel2.add(lblSer);
		panel2.add(chkSer);
	}
	
	private JTextField txtLength = new JTextField(20);
	private JLabel lblLength = new JLabel("跑道的长度");
	private JPanel panel3 = new JPanel();
	{
		panel3.add(lblLength);
		panel3.add(txtLength);
	}
	
	private JTextField txtIp = new JTextField(20);
	private JLabel lblIp = new JLabel("服务器地址");
	private JPanel panel4 = new JPanel();
	{
		panel4.add(lblIp);
		panel4.add(txtIp);
	}
	
	private JButton btnEnt = new JButton("进入游戏");
	public CreateOrJoinDialog(CarNetgameFrame f) {
		super(f);
		
		btnEnt.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							CarNetgameFrame owner = (CarNetgameFrame)CreateOrJoinDialog.this.getOwner();
							//取出姓名文本框中的数据
							String palyerName = txtName.getText();
							if(chkSer.isSelected()) {//判断“是否服务器选择按键”是否选择
								int length = Integer.parseInt(txtLength.getText());//取出“跑道长度文本框中”的数据，并转换成整数
								//创建服务器游戏模型
								CarNetGame model = new CarNetGameServer(palyerName,length);
								//给主窗体中的模型引用赋值
								owner.setModel(model);
								model.setCanvas(owner.getCavas());
								owner.getCavas().repaint();
							}else {
								//创建客户端游戏模型
								String ip = txtIp.getText();
								CarNetGame model = new CarNetGameClient(palyerName,ip);
								//给主窗体中的模型引用赋值
								owner.setModel(model);
								model.setCanvas(owner.getCavas());
								owner.getCavas().repaint();
							}
							
							CreateOrJoinDialog.this.dispose();
						}
					}
				);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(btnEnt);
		
		this.setSize(330, 240);
		this.setModal(true);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	} 
}
