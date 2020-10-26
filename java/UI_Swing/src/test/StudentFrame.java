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
	
	JButton btnInput = new JButton("�Է�");
	JButton btnUpgrade = new JButton("����");
	JButton btnDelete = new JButton("����");
	JButton btnSearch = new JButton("�˻�");
	
	JTextField txtSearch = new JTextField(10);
	static JTextArea txtResult = new JTextArea();
	
	String[] comboList = {"�л���", "����"}; 
	JComboBox<String> combo = new JComboBox<String>(comboList);
	final int STUDENT_NAME = 0;
	final int STUDENT_MAJOR = 1;
	
	MyDialog dialogInput = new MyDialog(null, "�л����� �Է�", 1);
	MyDialog dialogSearchUp = new MyDialog(null, "�л����� �˻�", 2);
	MyDialog dialogUpdate = new MyDialog(null, "�л����� ����", 3);
	MyDialog dialogSearchDel = new MyDialog(null, "�л����� ����", 4);
	
	JButton btnInputDialog = new JButton("�Է�");
	JButton btnClose = new JButton("���");
	JButton btnSearchDialog = new JButton("�˻�");
	JButton btnUpgradeDialog = new JButton("����");
	JButton btnDeleteDialog = new JButton("����");
	
	StudentDao dao = StudentDao.getInstance();
	
	public StudentFrame() {
		setTitle("�л� ���� ���α׷�");
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
	
	//���̾�α� ���� Ŭ���� ����, �Ű������� ���� �ٸ� ���̾�α� �����ϱ�
	class MyDialog extends JDialog {
		
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
		
		public MyDialog(Frame frame, String title,int type) {
			
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
				
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogInput.dispose();
					}
				});//addActionListener
				
				btnInputDialog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogInput.dispose();
						dataInput();
					}
				});//addActionListener
				
			} else if (type == 2) { //�й� �˻�->����
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
						try {
							String snoSearch = txtSno.getText();
							if (snoSearch == null || snoSearch.equals("")) {
								txtResult.append("------------------------------\n");
								txtResult.append("������ �й��� �Է����ּ���.\n");
								txtResult.append("------------------------------\n");
							} else if (snoSearch != null && !snoSearch.equals("")) {
								dialogSearchUp.dispose();
								dialogUpdate.setVisible(true);
								dataSearchUp(snoSearch);
								txtSno.setText(null);
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
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
				
				btnClose.addActionListener(new ActionListener() {
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
				});
			} else if (type == 4) { //����
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
						try {
							String snoSearch = txtSno.getText();
							if (snoSearch == null || snoSearch.equals("")) {
								txtResult.append("------------------------------\n");
								txtResult.append("������ �й��� �Է����ּ���.\n");
								txtResult.append("------------------------------\n");
							} else if (snoSearch != null && !snoSearch.equals("")) {
								dialogSearchDel.dispose();
								dataDelete(snoSearch);
								txtSno.setText(null);
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
					}
				});
			}//dialogSearchDel
		}//MyDialog
		
		//���̾�α׿��� �Է¹��� ����� StudentVo ��ü ����
		private StudentVo setStudentVo() {
			try {
				StudentVo vo = new StudentVo();
				
				String sno = txtSno.getText();
				String sname = txtSname.getText();
				int syear = Integer.parseInt(txtSyear.getText());
				String gender = null;
				if (rdoFemale.isSelected()) {
					gender = "��";
				} else if (rdoMale.isSelected()) {
					gender = "��";
				}
				String major = txtMajor.getText();
				int score = Integer.parseInt(txtScore.getText());
				
				//2001~2999�й�, 1~4�г�, 0~100��, �̸��� ������ ���� �ƴ�
                //���� �ɰ� ���� �Ͽ� �л� ���� �Է� ����
				int snoNum = Integer.parseInt(txtSno.getText());
				
				if (snoNum < 2000 || snoNum > 2999) {
					txtResult.append("------------------------------\n");
					txtResult.append("�й� ĭ���� 2001���� 2999 ������ �й��� �Է����ּ���.\n");
					txtResult.append("------------------------------\n");
					txtSno.setText(null);
				} else if (syear < 0 || syear > 4) {
					txtResult.append("------------------------------\n");
					txtResult.append("�г� ĭ���� 1�г���� 4�г� ������ �г��� �Է����ּ���.\n");
					txtResult.append("------------------------------\n");
					txtSyear.setText(null);
				} else if (score < 0 || score > 100) {
					txtResult.append("------------------------------\n");
					txtResult.append("���� ĭ���� 0������ 100�� ������ ������ �Է����ּ���.\n");
					txtResult.append("------------------------------\n");
					txtScore.setText(null);
				} else if (sname == null || sname.equals("")) {
					txtResult.append("------------------------------\n");
					txtResult.append("�̸��� ������ �Է��� �� �����ϴ�.\n");
					txtResult.append("------------------------------\n");
				} else if (major == null || major.equals("")) {
					txtResult.append("------------------------------\n");
					txtResult.append("������ ������ �Է��� �� �����ϴ�.\n");
					txtResult.append("------------------------------\n");
				} else if ((snoNum > 2000 && snoNum <= 2999) 
						&& (syear > 0 && syear <= 4) 
						&& (score >= 0 && score <= 100) 
						&& (sname != null || !sname.equals("")) 
						&& (major != null || !major.equals(""))) {
					vo = new StudentVo(sno, sname, syear, gender, major, score);
					System.out.println(vo.toString());
					
					return vo;
				}//else if
			} catch (Exception e) {
				e.printStackTrace();
				txtResult.append("------------------------------\n");
				txtResult.append("��� ������ �������� �Է����ּ���.\n");
				txtResult.append("------------------------------\n");
			}
			return null;
		}//getStudentVo
	
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
		
		if (obj == btnInput) { //�Է�â
			dialogInput.setVisible(true); 
		} else if (obj == btnUpgrade) { //���� �� �й� �˻�â
			dialogSearchUp.setVisible(true); 
		} else if (obj == btnDelete) { //����â
			dialogSearchDel.setVisible(true); 
		} else if (obj == btnSearch) { //�˻�â
			dataSearch();
			txtSearch.setText(null);
		}
	}//actionPerformed
	
	//������ �Է�
	private void dataInput() {
		StudentVo vo = dialogInput.setStudentVo();
		int count = dao.input(vo);
		
		dialogInput.txtSno.setText(null);
		dialogInput.txtSname.setText(null);
		dialogInput.txtSyear.setText(null);
		dialogInput.txtMajor.setText(null);
		dialogInput.txtScore.setText(null);
		txtResult.setText(count +"���� �л� ������ �Էµƽ��ϴ�. \n");
		txtResult.append(vo.getSname() +"�л� ������ �Էµƽ��ϴ�.");
	}//dataInput
	
	//���� �۾��� ���� �й� �˻�
	private void dataSearchUp(String snoSearch) {
		StudentVo vo = dao.searchUp(snoSearch);
		
		dialogUpdate.txtSno.setText(vo.getSno());
		dialogUpdate.txtSname.setText(vo.getSname());
		dialogUpdate.txtSyear.setText(String.valueOf(vo.getSyear()));
		if (vo.getGender().equals("��")) {
			dialogUpdate.rdoFemale.setSelected(true);
		} else {
			dialogUpdate.rdoMale.setSelected(true);
		}
		dialogUpdate.txtMajor.setText(vo.getMajor());
		dialogUpdate.txtScore.setText(String.valueOf(vo.getScore()));
	}//dataSearchUp

	//���� �۾�
	private void dataUpdate() {
		StudentVo vo = dialogUpdate.setStudentVo();
		int count = dao.update(vo);
		
		dialogUpdate.txtSno.setText(null);
		dialogUpdate.txtSname.setText(null);
		dialogUpdate.txtSyear.setText(null);
		dialogUpdate.txtMajor.setText(null);
		dialogUpdate.txtScore.setText(null);
		txtResult.setText(count +"���� �л� ������ �����ƽ��ϴ�. \n");
		txtResult.append(vo.getSname() +"�л� ������ �����ƽ��ϴ�.");
	}//dataUpdate

	//���� �۾�
	private void dataDelete(String sno) {
		int count = dao.delete(sno);
		dialogSearchDel.txtSno.setText(null);
		txtResult.setText(count +"���� �л� ������ �����ƽ��ϴ�. \n");
	}//dataDelete

	//��ü �˻� Ȥ�� �̸��̳� ���� �κ� �˻�
	private void dataSearch() {
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
