package ex08;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ToolbarEx extends JFrame {

	public ToolbarEx() {
		setTitle("ToolbarEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setToolbar();
		setSize(500, 500);
		setVisible(true);
	}

	private void setToolbar() {
		JToolBar toolBar = new JToolBar("My Tool");
		JButton button = new JButton("Click");
		button.addMouseListener(new MouseAdapter() { //{}구현 메소드 중에 필요한 거만 사용 가능
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
			}
		});
		toolBar.add(new JButton("Button"));
		toolBar.add(new JLabel("Searching : "));
		toolBar.add(new JTextField(10));
		toolBar.add(new JLabel(new ImageIcon("images/smile_small.png")));
		toolBar.add(new JComboBox<String>(new String[] {"A", "B", "C"}));
		getContentPane().add(toolBar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ToolbarEx();
	}

}//class
