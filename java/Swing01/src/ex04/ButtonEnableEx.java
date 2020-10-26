package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonEnableEx extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JButton btn1 = new JButton("숨기기/보이기");
	JButton btn2 = new JButton("모양 정보");
	JButton btn3 = new JButton("비활성화");
	JButton btn4 = new JButton("위치/크기 정보");
	
	public ButtonEnableEx() {
		setTitle("활성화 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		c.setLayout(new FlowLayout());
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btn4);
		
		btn2.setBackground(Color.yellow);
		btn2.setForeground(Color.cyan);
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		
		btn3.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new ButtonEnableEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("이벤트 발생");
		Object obj = e.getSource();
		
		if (obj == btn1) {
			if (btn3.isVisible() == true) {
				btn3.setVisible(false);
			} else {
				btn3.setVisible(true);
			}
		} else if(obj == btn2) {
			System.out.println(btn2.getBackground());
			System.out.println(btn2.getForeground());
			System.out.println(btn2.getFont());
		} else if(obj == btn4) {
			System.out.println("x: "+btn4.getX());
			System.out.println("y: "+btn4.getY());
			System.out.println("width: "+btn4.getWidth());
			System.out.println("height: "+btn4.getHeight());
		}
	}
	
}//class
