package filetranser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class main_choice{
	public static void main(String[] args) {
		new main_choice();
	}
	
	public main_choice() {
		JFrame myJframe=new JFrame("选择传输类型");
		
//		获取屏幕寬高使程序从屏幕中间出现
		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
		int s_width=(int)screen.getWidth();
		int s_height=(int)screen.getHeight();
		
		myJframe.setLayout(new GridLayout(2, 1));
		
		JButton btn_recieve=new JButton();
		btn_recieve.setText("接收");
		btn_recieve.setBackground(new Color(19, 209, 61));
		btn_recieve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_btn_recieve(myJframe);
			}
		});
		
		JButton btn_sent=new JButton();
		btn_sent.setText("发送");
		btn_sent.setBackground(new Color(252, 190, 7));
		btn_sent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_btn_sent(myJframe);
			}
		});
		
		JPanel jp_up=new JPanel();
		JPanel jp_down=new JPanel();
		
		jp_up.add(btn_recieve);
		jp_down.add(btn_sent);
		
		myJframe.add(btn_recieve);
		myJframe.add(btn_sent);
		
//		myJframe.setBounds(s_width/2-myJframe.getWidth()/2, w_height/2-myJframe.getHeight()/2, 200, 250);
		myJframe.setSize(200, 250);
		myJframe.setLocation(s_width/2-myJframe.getWidth()/2, s_height/2-myJframe.getHeight()/2);
		myJframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJframe.setVisible(true);
		myJframe.setLocationRelativeTo(null);
	}
	
	private void do_btn_recieve(JFrame myJframe) {
//		JOptionPane.showMessageDialog(myJframe, "recieve", "接收", JOptionPane.CLOSED_OPTION);
		new recieve_socket();
	}
	
	private void do_btn_sent(JFrame myJframe) {
//		JOptionPane.showMessageDialog(myJframe, "sent", "发送", JOptionPane.CLOSED_OPTION);
		new sent_socket();
	}

}
