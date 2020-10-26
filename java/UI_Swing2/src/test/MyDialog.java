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
	JLabel lblSno = new JLabel("�й�");
	JLabel lblSname = new JLabel("�л��̸�");
	JLabel lblSyear = new JLabel("�г�");
	JLabel lblGender = new JLabel("����");
	JLabel lblMajor = new JLabel("����");
	JLabel lblScore = new JLabel("����");
	
	JTextField txtSno = new JTextField(10);
	JTextField txtSname = new JTextField(10);
	JTextField txtSyear = new JTextField(10);
	JTextField txtMajor = new JTextField(10);
	JTextField txtScore = new JTextField(10);
	
	JRadioButton rdoFemale = new JRadioButton("����");
	JRadioButton rdoMale = new JRadioButton("����");
	ButtonGroup bg = new ButtonGroup();
	
	JButton btnInputDialog = new JButton("�Է�");
	JButton btnClose = new JButton("���");
	JButton btnSearchDialog = new JButton("�˻�");
	JButton btnUpgradeDialog = new JButton("����");
	JButton btnDeleteDialog = new JButton("����");
	
	String str = "�ӽ�";
	//StudentFrame fr = null;
	
	StudentDao dao = StudentDao.getInstance();
	
	public MyDialog(Frame frame, String title,int type) {
		
		setListener();
		
		if (type == 1) { //�Է�â
			this.setSize(300, 400);
			this.setLayout(new GridLayout(7, 2));
			this.add(lblSno);
			this.add(txtSno);
			this.add(lblSname);
			this.add(txtSname);
			this.add(lblSyear);
			this.add(txtSyear);
			this.add(lblGender);
			//���� ���� ��ư
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
			
		} else if (type == 2) { //�й� �˻�->����
			this.setSize(300, 100);
			this.setLayout(new GridLayout(2, 2));
			this.add(lblSno);
			this.add(txtSno);
			this.add(btnClose);
			this.add(btnSearchDialog);
			
		} else if (type == 3) { //����
			this.setSize(300, 400);
			this.setLayout(new GridLayout(7, 2));
			this.add(lblSno);
			this.add(txtSno);
			this.add(lblSname);
			this.add(txtSname);
			this.add(lblSyear);
			this.add(txtSyear);
			this.add(lblGender);
			//���� ���� ��ư
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
		} else if (type == 4) { //����
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
					System.out.println("���� ���̾�α�");
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
			gender = "����";
		} else if (rdoMale.isSelected()) {
			gender = "����";
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
			txtResult.append("�й� ĭ���� 2001���� 2999 ������ �й��� �Է����ּ���.\n");
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
			txtResult.append("�г� ĭ���� 1�г���� 4�г� ������ �г��� �Է����ּ���.\n");
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
			txtResult.append("���� ĭ���� 0������ 100�� ������ ������ �Է����ּ���.\n");
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
			MyDialog dialogUpdate = new MyDialog(null, "�л����� ����", 3);
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
		StudentFrame.txtResult.setText(count +"���� �л� ������ �Էµƽ��ϴ�. \n");
		StudentFrame.txtResult.append(vo.getSname() +"�л� ������ �Էµƽ��ϴ�.");
		
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
		if (vo.getGender().equals("����")) {
			this.rdoFemale.isSelected();
		} else{
			this.rdoMale.isSelected();
		}
		this.txtMajor.setText(vo.getMajor());
		this.txtScore.setText(String.valueOf(vo.getScore()));
	}//dataSearchUp
	
}//class MyDialog
