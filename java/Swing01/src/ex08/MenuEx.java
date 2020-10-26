package ex08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuEx extends JFrame {

	public MenuEx() {
		setTitle("MenuEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenu();
		setSize(500, 500);
		setVisible(true);
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuEdit = new JMenu("Edit");
		
		//file
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miOpen = new JMenuItem("Open");
		mnuFile.add(miNew);
		mnuFile.add(miOpen);
		
		//edit
		JMenuItem miCopy = new JMenuItem("Copy");
		JMenuItem miPaste = new JMenuItem("Paste");
		JMenuItem miCut = new JMenuItem("Cut");
		mnuEdit.add(miCopy);
		mnuEdit.add(miPaste);
		mnuEdit.addSeparator(); //----------(�и���)
		mnuEdit.add(miCut);
		
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("New �޴��� ������");
			}
		});
		
		menuBar.add(mnuFile); //�޴��ٿ� �޴� �ޱ�
		menuBar.add(mnuEdit);
		setJMenuBar(menuBar); //�����ӿ� �޴��� �ޱ�
	}

	public static void main(String[] args) {
		new MenuEx();
	}

}//class
