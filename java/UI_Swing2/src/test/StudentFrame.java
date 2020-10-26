package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	
	JButton btnInput = new JButton("입력");
	JButton btnUpgrade = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	
	JTextField txtSearch = new JTextField(10);
	static JTextArea txtResult = new JTextArea();
	
	String[] comboList = {"학생명", "전공"}; 
	JComboBox<String> combo = new JComboBox<String>(comboList);
	final int STUDENT_NAME = 0;
	final int STUDENT_MAJOR = 1;
	
	MyDialog dialogInput = new MyDialog(null, "학생정보 입력", 1);
	MyDialog dialogSearchUp = new MyDialog(null, "학생정보 검색", 2);
	MyDialog dialogUpdate = new MyDialog(null, "학생정보 수정", 3);
	MyDialog dialogSearchDel = new MyDialog(null, "학생정보 삭제", 4);
	
	MyDialog dialog = new MyDialog(null, null, 0);
	
	JButton btnInputDialog = new JButton("입력");
	JButton btnClose = new JButton("취소");
	JButton btnSearchDialog = new JButton("검색");
	JButton btnUpgradeDialog = new JButton("수정");
	JButton btnDeleteDialog = new JButton("삭제");
	
	StudentDao dao = StudentDao.getInstance();
	
	//public StudentFrame(String str) {}

	public StudentFrame() {
		setTitle("학생 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		
		setUI();
		setListener();
	}//StudentFrame

	private void setUI() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(btnInput);
		pnlNorth.add(btnUpgrade);
		pnlNorth.add(btnDelete);
		pnlNorth.add(combo);
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		c.add(pnlNorth, new BorderLayout().NORTH);
		
		c.add(txtResult, new BorderLayout().CENTER);
	}//setUI
	
	class MyDialog extends JDialog {
		
		JLabel lblSno = new JLabel("학번");
		JLabel lblSname = new JLabel("학생이름");
		JLabel lblSyear = new JLabel("학년");
		JLabel lblGender = new JLabel("성별");
		JLabel lblMajor = new JLabel("전공");
		JLabel lblScore = new JLabel("점수");
		
		JTextField txtSno = new JTextField(10);
		JTextField txtSname = new JTextField(10);
		JTextField txtSyear = new JTextField(10);
		JTextField txtMajor = new JTextField(10);
		JTextField txtScore = new JTextField(10);
		
		JRadioButton rdoFemale = new JRadioButton("여자");
		JRadioButton rdoMale = new JRadioButton("남자");
		ButtonGroup bg = new ButtonGroup();
		
		JButton btnInputDialog = new JButton("입력");
		JButton btnClose = new JButton("취소");
		JButton btnSearchDialog = new JButton("검색");
		JButton btnUpgradeDialog = new JButton("수정");
		JButton btnDeleteDialog = new JButton("삭제");
		
		public MyDialog(Frame frame, String title,int type) {
			
			if (type == 1) { //입력창
				this.setSize(300, 400);
				this.setLayout(new GridLayout(7, 2));
				this.add(lblSno);
				this.add(txtSno);
				this.add(lblSname);
				this.add(txtSname);
				this.add(lblSyear);
				this.add(txtSyear);
				this.add(lblGender);
				//성별 라디오 버튼
				bg.add(rdoFemale);
				bg.add(rdoMale);
				rdoFemale.setSelected(true);
				JPanel pnlBg = new JPanel();
				pnlBg.add(rdoFemale);
				pnlBg.add(rdoMale);
				this.add(pnlBg);
				
				this.add(lblMajor);
				this.add(txtMajor);
				this.add(lblScore);
				this.add(txtScore);
				
				this.add(btnClose);
				this.add(btnInputDialog);
				
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogInput.dispose();
					}
				});//addActionListener
				
				btnInputDialog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVoClean();
					}
				});//addActionListener
				
			} else if (type == 2) { //학번 검색->수정
				this.setSize(300, 100);
				this.setLayout(new GridLayout(2, 2));
				this.add(lblSno);
				this.add(txtSno);
				this.add(btnClose);
				this.add(btnSearchDialog);
				
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogSearchUp.dispose();
					}
				});
				
				btnSearchDialog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogSearchUp.dispose();
						dialogUpdate.setVisible(true);
						
						String snoSearch = txtSno.getText();
						dataSearchUp(snoSearch);
					}
				});
			} else if (type == 3) { //수정
				this.setSize(300, 400);
				this.setLayout(new GridLayout(7, 2));
				this.add(lblSno);
				this.add(txtSno);
				this.add(lblSname);
				this.add(txtSname);
				this.add(lblSyear);
				this.add(txtSyear);
				this.add(lblGender);
				//성별 라디오 버튼
				bg.add(rdoFemale);
				bg.add(rdoMale);
				rdoFemale.setSelected(true);
				JPanel pnlBg = new JPanel();
				pnlBg.add(rdoFemale);
				pnlBg.add(rdoMale);
				this.add(pnlBg);
				
				this.add(lblMajor);
				this.add(txtMajor);
				this.add(lblScore);
				this.add(txtScore);
				
				this.add(btnClose);
				this.add(btnUpgradeDialog);
				
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogUpdate.dispose();
					}
				});
				
				btnUpgradeDialog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVoClean();
					}
				});
			} else if (type == 4) { //삭제
				this.setSize(300, 100);
				this.setLayout(new GridLayout(2, 2));
				this.add(lblSno);
				this.add(txtSno);
				this.add(btnClose);
				this.add(btnDeleteDialog);
				
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogSearchDel.dispose();
					}
				});
				
				btnDeleteDialog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("수정 다이얼로그");
						dialogSearchDel.dispose();
						
						String snoSearvh = txtSno.getText();
						dataDelete(snoSearvh);
					}
				});
			}//dialogSearchDel
		}//MyDialog
		
		private StudentVo getStudentVo() {
			StudentVo vo = new StudentVo();
			
			String sno = txtSno.getText();
			String sname = txtSname.getText();
			int syear = Integer.parseInt(txtSyear.getText());
			String gender = null;
			if (rdoFemale.isSelected()) {
				gender = "여자";
			} else if (rdoMale.isSelected()) {
				gender = "남자";
			}
			String major = txtMajor.getText();
			int score = Integer.parseInt(txtScore.getText());
			
			vo = new StudentVo(sno, sname, syear, gender, major, score);
			
			System.out.println(vo.toString());
			
			return vo;
		}//getStudentVo
		
		private void setVoClean() {
			int sno = Integer.parseInt(txtSno.getText());
			int syear = Integer.parseInt(txtSyear.getText());
			int score = Integer.parseInt(txtScore.getText());
			
			
			if (sno < 2000 || score > 2999) {
				txtResult.append("------------------------------\n");
				txtResult.append("학번 칸에는 2001부터 2999 사이의 학번을 입력해주세요.\n");
				txtResult.append("------------------------------\n");
				txtSno.setText(null);
			} else if (syear < 0 || syear > 4) {
				txtResult.append("------------------------------\n");
				txtResult.append("학년 칸에는 1학년부터 4학년 사이의 학년을 입력해주세요.\n");
				txtResult.append("------------------------------\n");
				txtSyear.setText(null);
			} else if (score < 0 || score > 100) {
				txtResult.append("------------------------------\n");
				txtResult.append("점수 칸에는 0점부터 100점 사이의 점수를 입력해주세요.\n");
				txtResult.append("------------------------------\n");
				txtScore.setText(null);
			} if ((sno > 2000 && score <= 2999) && (syear > 0 && syear <= 4) 
					&& (score > 0 && score <= 100)) {
				if (dialogInput.isActive()) {
					dialogInput.dispose();
					dataInput();
				} else if (dialogUpdate.isActive()) {
					dialogUpdate.dispose();
					dataUpdate();
				}
			}
		}//setVoClean
		
	}//class MyDialog
	
	private void setListener() {
		btnInput.addActionListener(this);
		btnUpgrade.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
	}//setListener

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnInput) {
			dialogInput.setVisible(true); //입력창
		} else if (obj == btnUpgrade) {
			dialogSearchUp.setVisible(true); //수정 전 학번 검색창
		} else if (obj == btnDelete) {
			dialogSearchDel.setVisible(true); //삭제창
		} else if (obj == btnSearch) {
			dataSearch();
		}
	}//actionPerformed
	
	void dataInput() {
		StudentVo vo = dialogInput.getStudentVo();
		int count = dao.input(vo);
		
		dialogInput.txtSno.setText(null);
		dialogInput.txtSname.setText(null);
		dialogInput.txtSyear.setText(null);
		dialogInput.txtMajor.setText(null);
		dialogInput.txtScore.setText(null);
		txtResult.setText(count +"명의 학생 정보가 입력됐습니다. \n");
		txtResult.append(vo.getSname() +"학생 정보가 입력됐습니다.");
	}//dataInput
	
	void dataSearchUp(String snoSearch) {
		StudentVo vo = dao.searchUp(snoSearch);
		
		dialogUpdate.txtSno.setText(vo.getSno());
		dialogUpdate.txtSname.setText(vo.getSname());
		dialogUpdate.txtSyear.setText(String.valueOf(vo.getSyear()));
		if (vo.getGender().equals("여자")) {
			dialogUpdate.rdoFemale.isSelected();
		} else{
			dialogUpdate.rdoMale.isSelected();
		}
		dialogUpdate.txtMajor.setText(vo.getMajor());
		dialogUpdate.txtScore.setText(String.valueOf(vo.getScore()));
	}//dataSearchUp

	void dataUpdate() {
		StudentVo vo = dialogUpdate.getStudentVo();
		int count = dao.update(vo);
		
		dialogUpdate.txtSno.setText(null);
		dialogUpdate.txtSname.setText(null);
		dialogUpdate.txtSyear.setText(null);
		dialogUpdate.txtMajor.setText(null);
		dialogUpdate.txtScore.setText(null);
		txtResult.setText(count +"명의 학생 정보가 수정됐습니다. \n");
		txtResult.append(vo.getSname() +"학생 정보가 수정됐습니다.");
	}//dataUpdate

	void dataDelete(String sno) {
		int count = dao.delete(sno);
		dialogSearchDel.txtSno.setText(null);
		txtResult.setText(count +"명의 학생 정보가 삭제됐습니다. \n");
	}//dataDelete

	void dataSearch() {
		String searchTxt = txtSearch.getText();
		int type = 0;
		if (combo.getSelectedIndex() == STUDENT_NAME) {
			type = STUDENT_NAME;
		} else if (combo.getSelectedIndex() == STUDENT_MAJOR) {
			type = STUDENT_MAJOR;
		}
		ArrayList<StudentVo> list = dao.search(searchTxt, type);
		
		StringBuffer buffer = new StringBuffer();
		for (StudentVo vo : list) {
			buffer.append(vo.getSno());    buffer.append(" | ");
			buffer.append(vo.getSname());  buffer.append(" | ");
			buffer.append(vo.getSyear());  buffer.append(" | ");
			buffer.append(vo.getGender()); buffer.append(" | ");
			buffer.append(vo.getMajor());  buffer.append(" | ");
			buffer.append(vo.getScore());  buffer.append(" | \n");
		}
		txtResult.setText(buffer.toString());
	}//dataSearch
	
	public static void main(String[] args) {
		new StudentFrame();
	}//main

}//StudentFrame
