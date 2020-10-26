package ex08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FileChooserEx extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JTextArea textArea = new JTextArea();
	
	JMenuItem miNew =new JMenuItem("New");
	JMenuItem miOpen =new JMenuItem("Open");
	JMenuItem miSave =new JMenuItem("Save");

	public FileChooserEx() {
		setTitle("FileChooserEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenu();
		setUI();
		setSize(500, 500);
		setVisible(true);
	}

	private void setUI() {
		textArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		c.add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		mnuFile.add(miNew);
		mnuFile.add(miOpen);
		mnuFile.add(miSave);
		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		menuBar.add(mnuFile);
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == miNew) {
			
		} else if (obj == miOpen) {
			JFileChooser chooserOpen = new JFileChooser();
			int open = chooserOpen.showOpenDialog(null); //화면기준 가운데 //Filechooser.this 프레임 기준
			if (open == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooserOpen.getSelectedFile();
				String openPath = selectedFile.getAbsolutePath();
//				System.out.println(openPath); //G:\workspace\html\1.png 위치 보여줌
				try {
//					FileReader fr = new FileReader(openPath); //파일 읽기
					FileInputStream fis = new FileInputStream(openPath);
					InputStreamReader isr = new InputStreamReader(fis, "utf-8"); //한글 안 깨지게
					BufferedReader br = new BufferedReader(isr); //버퍼로 데이터 모아서 읽기
//					BufferedReader br = new BufferedReader(
//							new InputStreamReader(new FileInputStream(openPath), "utf-8"));
					while (true) {
						String str = br.readLine(); //무한반복 중에, 1줄씩 읽기
						if (str ==null) {
							break;
						}
						textArea.append(str+"\n"); //프레임 화면에 1줄씩 내리면서 보여줌
					}
					br.close(); //다하면 버퍼 종료
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		} else if (obj == miSave) {
			JFileChooser chooserSave = new JFileChooser();
			chooserSave.showOpenDialog(null);
		}
	}//actionPerformed
	
	public static void main(String[] args) {
		new FileChooserEx();
	}

}//class
