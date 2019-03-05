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
	private JLabel lblName = new JLabel("�������");
	private JPanel panel1 = new JPanel();
	{
		panel1.add(lblName);
		panel1.add(txtName);
	}
	
	private JCheckBox chkSer = new JCheckBox();
	private JLabel lblSer = new JLabel("�Ƿ���Ϊ������");
	private JPanel panel2 = new JPanel();
	{
		panel2.add(lblSer);
		panel2.add(chkSer);
	}
	
	private JTextField txtLength = new JTextField(20);
	private JLabel lblLength = new JLabel("�ܵ��ĳ���");
	private JPanel panel3 = new JPanel();
	{
		panel3.add(lblLength);
		panel3.add(txtLength);
	}
	
	private JTextField txtIp = new JTextField(20);
	private JLabel lblIp = new JLabel("��������ַ");
	private JPanel panel4 = new JPanel();
	{
		panel4.add(lblIp);
		panel4.add(txtIp);
	}
	
	private JButton btnEnt = new JButton("������Ϸ");
	public CreateOrJoinDialog(CarNetgameFrame f) {
		super(f);
		
		btnEnt.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							CarNetgameFrame owner = (CarNetgameFrame)CreateOrJoinDialog.this.getOwner();
							//ȡ�������ı����е�����
							String palyerName = txtName.getText();
							if(chkSer.isSelected()) {//�жϡ��Ƿ������ѡ�񰴼����Ƿ�ѡ��
								int length = Integer.parseInt(txtLength.getText());//ȡ�����ܵ������ı����С������ݣ���ת��������
								//������������Ϸģ��
								CarNetGame model = new CarNetGameServer(palyerName,length);
								//���������е�ģ�����ø�ֵ
								owner.setModel(model);
								model.setCanvas(owner.getCavas());
								owner.getCavas().repaint();
							}else {
								//�����ͻ�����Ϸģ��
								String ip = txtIp.getText();
								CarNetGame model = new CarNetGameClient(palyerName,ip);
								//���������е�ģ�����ø�ֵ
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
