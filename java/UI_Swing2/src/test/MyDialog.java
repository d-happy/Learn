package test;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class MyDialog extends JDialog implements ActionListener {
	
	//private static final StudentFrame getStudentFrame(); = null;
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
	
	String str = "임시";
	//StudentFrame fr = null;
	
	StudentDao dao = StudentDao.getInstance();
	
	public MyDialog(Frame frame, String title,int type) {
		
		setListener();
		
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
			
		} else if (type == 2) { //학번 검색->수정
			this.setSize(300, 100);
			this.setLayout(new GridLayout(2, 2));
			this.add(lblSno);
			this.add(txtSno);
			this.add(btnClose);
			this.add(btnSearchDialog);
			
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
			
			/*btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialogUpdate.dispose();
				}
			});
			
			btnUpgradeDialog.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialogUpdate.dispose();
					dataUpdate();
				}
			});*/
		} else if (type == 4) { //삭제
			this.setSize(300, 100);
			this.setLayout(new GridLayout(2, 2));
			this.add(lblSno);
			this.add(txtSno);
			this.add(btnClose);
			this.add(btnDeleteDialog);
			
			/*btnClose.addActionListener(new ActionListener() {
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
			});*/
		}//dialogSearchDel
	}//MyDialog

	public StudentVo getStudentVo() {
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
		
		/*if (sno < 2000 || score > 2999) {
			txtResult.append("------------------------------\n");
			txtResult.append("학번 칸에는 2001부터 2999 사이의 학번을 입력해주세요.\n");
			txtResult.append("------------------------------");
			txtSno.setText(null);
		} else {
			if (dialogInput.isActive()) {
				dialogInput.dispose();
				dataInput();
			} else if (dialogUpdate.isActive()) {
				dialogUpdate.dispose();
				dataUpdate();
			}
		}
		
		if (syear < 0 || syear > 4) {
			txtResult.append("------------------------------\n");
			txtResult.append("학년 칸에는 1학년부터 4학년 사이의 학년을 입력해주세요.\n");
			txtResult.append("------------------------------");
			txtSyear.setText(null);
		} else {
			if (dialogInput.isActive()) {
				dialogInput.dispose();
				dataInput();
			} else if (dialogUpdate.isActive()) {
				dialogUpdate.dispose();
				dataUpdate();
			}
		}
		
		if (score < 0 || score > 100) {
			txtResult.append("------------------------------\n");
			txtResult.append("점수 칸에는 0점부터 100점 사이의 점수를 입력해주세요.\n");
			txtResult.append("------------------------------");
			txtScore.setText(null);
		} else {
			if (dialogInput.isActive()) {
				dialogInput.dispose();
				dataInput();
			} else if (dialogUpdate.isActive()) {
				dialogUpdate.dispose();
				dataUpdate();
			}
		}*/
	}//setVoClean
	
	private void setListener() {
		btnClose.addActionListener(this);
		btnInputDialog.addActionListener(this);
		btnSearchDialog.addActionListener(this);
		btnUpgradeDialog.addActionListener(this);
		btnDeleteDialog.addActionListener(this);
	}//setListener

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//StudentFrame fr = this.getStudentFrame(fr);
		
		if (obj == btnClose) {
			System.out.println("djdjdj");
			this.dispose();
		} else if (obj == btnInputDialog) {
			System.out.println("yuyuyuyuyu");
			dataInput();
			this.dispose();
		} else if (obj == btnSearchDialog) {
			String snoSearch = this.txtSno.getText();
			MyDialog dialogUpdate = new MyDialog(null, "학생정보 수정", 3);
			dialogUpdate.setVisible(true);
			dataSearchUp(snoSearch);
		}
		
	}//actionPerformed
	
	private void dataInput() {
		StudentVo vo = this.getStudentVo();
		int count = dao.input(vo);
		
		this.txtSno.setText(null);
		this.txtSname.setText(null);
		this.txtSyear.setText(null);
		this.txtMajor.setText(null);
		this.txtScore.setText(null);
		StudentFrame.txtResult.setText(count +"명의 학생 정보가 입력됐습니다. \n");
		StudentFrame.txtResult.append(vo.getSname() +"학생 정보가 입력됐습니다.");
		
		System.out.println(vo.toString());
	}//dataInput
	
	StudentFrame getStudentFrame(StudentFrame fr) {
		//this.fr = fr;
		return fr;
	}
	
	private void dataSearchUp(String snoSearch) {
		StudentVo vo = dao.searchUp(snoSearch);
		
		this.txtSno.setText(vo.getSno());
		this.txtSname.setText(vo.getSname());
		this.txtSyear.setText(String.valueOf(vo.getSyear()));
		if (vo.getGender().equals("여자")) {
			this.rdoFemale.isSelected();
		} else{
			this.rdoMale.isSelected();
		}
		this.txtMajor.setText(vo.getMajor());
		this.txtScore.setText(String.valueOf(vo.getScore()));
	}//dataSearchUp
	
}//class MyDialog
