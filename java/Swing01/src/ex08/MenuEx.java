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
		mnuEdit.addSeparator(); //----------(분리선)
		mnuEdit.add(miCut);
		
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("New 메뉴를 선택함");
			}
		});
		
		menuBar.add(mnuFile); //메뉴바에 메뉴 달기
		menuBar.add(mnuEdit);
		setJMenuBar(menuBar); //프레임에 메뉴바 달기
	}

	public static void main(String[] args) {
		new MenuEx();
	}

}//class
