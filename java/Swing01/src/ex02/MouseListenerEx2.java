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
//	MouseListener lis = new MyMouseListener(); //마우스 감시자
	JButton btnTarget = new JButton("버튼");
	
	public MouseListenerEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 리스너 예제 2"); 
		
		setLayout(new FlowLayout());
		btnTarget.addMouseListener(new MouseListener() {
			
			//익명클래스 - btnTarget 전담 마크 (1회용), 이름 없어서 1회용
			
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
