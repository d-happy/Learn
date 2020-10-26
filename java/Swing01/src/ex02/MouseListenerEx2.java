package ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MouseListenerEx2 extends JFrame {
	
	Container c = getContentPane();
//	MouseListener lis = new MyMouseListener(); //���콺 ������
	JButton btnTarget = new JButton("��ư");
	
	public MouseListenerEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���콺 ������ ���� 2"); 
		
		setLayout(new FlowLayout());
		btnTarget.addMouseListener(new MouseListener() {
			
			//�͸�Ŭ���� - btnTarget ���� ��ũ (1ȸ��), �̸� ��� 1ȸ��
			
			@Override
			public void mouseReleased(MouseEvent e) {
				c.setBackground(Color.yellow);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				c.setBackground(Color.green);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		
		c.add(btnTarget); 
		
		setSize(500, 500); 
		setVisible(true); 
	}
	
	
	
	public static void main(String[] args) {
		new MouseListenerEx2();
	}

}//class
