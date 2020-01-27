package KIOSK;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Dialogue extends JDialog implements ActionListener{
	
	JButton ok=new JButton("확인");
	JFrame frame=new JFrame();
	public Dialogue(JFrame j,ArrayList<Excelmember> i) {
		
		super(j, "번호창");
		frame=j;
		JLabel label=new JLabel("주문번호는 "+Integer.toString(i.get(0).getOrdernum()));
		label.setFont(new Font("맑은 고딕",Font.BOLD,30));
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(new BorderLayout());
		add("Center",label);
		add("South",ok);
		ok.addActionListener(this);
		setSize(200,200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		dispose();		
	}
	
}
