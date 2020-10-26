package ex08;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextMove extends JFrame implements ActionListener {
	
	JLabel label = new JLabel("Hello");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnuText = new JMenu("Text");
	
	JMenuItem miTop = new JMenuItem("Top");
	JMenuItem miBottom = new JMenuItem("Bottom");
	JMenuItem miLeft = new JMenuItem("Left");
	JMenuItem miRight = new JMenuItem("Right");

	public TextMove() {
		setTitle("TextMove");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setMenu();
		setSize(500, 500);
		setVisible(true);
	}

	private void setUI() {
		Container c = getContentPane();
		c.add(label);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void setMenu() {
		mnuText.add(miTop);
		mnuText.add(miBottom);
		mnuText.addSeparator();
		mnuText.add(miLeft);
		mnuText.add(miRight);
		
		miTop.addActionListener(this);
		miBottom.addActionListener(this);
		miLeft.addActionListener(this);
		miRight.addActionListener(this);

		menuBar.add(mnuText);
		setJMenuBar(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == miTop) {
			label.setVerticalAlignment(SwingConstants.TOP);
			label.setHorizontalAlignment(SwingConstants.CENTER);
		} else if (obj == miBottom) {
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.CENTER);
		} else if (obj == miLeft) {
			label.setVerticalAlignment(SwingConstants.CENTER);
			label.setHorizontalAlignment(SwingConstants.LEFT);
		} else if (obj == miRight) {
			label.setVerticalAlignment(SwingConstants.CENTER);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
		}
	}//actionPerformed

	public static void main(String[] args) {
		new TextMove();
	}

}//class
