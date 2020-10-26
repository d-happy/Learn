package ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oracle.net.aso.p;

@SuppressWarnings("serial")
public class EmpFrame extends JFrame{
	
	Container c = getContentPane();
	JPanel pnlNorth = new JPanel();
	JPanel pnlSouth = new JPanel();
	JButton btnAll = new JButton("��ü��ȸ");
	JLabel lblSearch = new JLabel("�˻�:");
	JButton btnSearch = new JButton("�˻�");
	JButton btnDelete = new JButton("����");
	JButton btnInput = new JButton("�߰�");
	JTextField txtSearch = new JTextField(10);
	JTextArea txtResult = new JTextArea();
	EmpDao dao = EmpDao.getInstance();
	
//	int[] inputData = new int[]{0,1,2,3,4,5,6,7};
	
	public EmpFrame() {
		setTitle("��� ���� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		setUI();
		setListenner();
	}
	
	private void setListenner() {
		
		btnAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<EmpVO> list = dao.selectAll();
//				System.out.println(list);
				txtResult.append("--------------------------------\n");
				for (EmpVO vo : list) {
					String str = "";
					int empno = vo.getEmpno();
					String ename = vo.getEname();
					String job = vo.getJob();
					int mgr = vo.getMgr();
					Date hiredate = vo.getHiredate(); //java.sql.Date;
					int sal = vo.getSal();
					int comm = vo.getComm();
					int deptno = vo.getDeptno();
					str += empno + " | ";
					str += ename + " | ";
					str += job + " | ";
					str += mgr + " | ";
					str += hiredate + " | ";
					str += sal + " | ";
					str += comm + " | ";
					str += deptno + " \n ";
					txtResult.append(str);
				}
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtSearch.getText();
				//txtSearch�� �Է��� ��  String ������ ����
				List<EmpVO> list = dao.searchEname(name); 
				//searchEname�� ��� ����Ʈ�� ����
				txtResult.setText("");
				txtResult.append("--------------------------------\n");
				
				for (EmpVO vo : list) {
					String str = "";
					int empno = vo.getEmpno();
					String ename = vo.getEname();
					String job = vo.getJob();
					int mgr = vo.getMgr();
					Date hiredate = vo.getHiredate(); //java.sql.Date;
					int sal = vo.getSal();
					int comm = vo.getComm();
					int deptno = vo.getDeptno();
					str += empno + " | ";
					str += ename + " | ";
					str += job + " | ";
					str += mgr + " | ";
					str += hiredate + " | ";
					str += sal + " | ";
					str += comm + " | ";
					str += deptno + " \n ";
					txtResult.append(str);
				} //�ϳ��ϳ� EmpVO, ����Ʈ ���� �������� vo���� get�ؼ� �����
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("delete");
				
				String name = txtSearch.getText();
				dao.delete(name);
			}
		});
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("input");
//				dao.inputData();
				
				String empno = txtSearch.getText();
				
				String[] inputData = new String[]{empno, ename, job, hiredate, sal, comm, deptno};
				
			}
		});
		
	}//setListenner

	private void setUI() {
		
//		txtResult.setFont(new Font("Dialog", Font.BOLD, 12));
		
		pnlNorth.setBackground(Color.yellow);
		pnlNorth.add(btnAll);
		pnlNorth.add(lblSearch);
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		pnlNorth.add(btnDelete);
		pnlNorth.add(new JLabel("|"));
		pnlNorth.add(btnInput);
		
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(new JScrollPane(txtResult), BorderLayout.CENTER);
		
//		empno, ename, job, mgr, hiredate, sal, comm, deptno
		
		pnlSouth.setLayout(new GridLayout(2,8));
		pnlSouth.add(new JLabel("��� ��ȣ"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("��� �̸�"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("��� �����ȣ"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("�Ի� ��¥"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("Ŀ�̼�"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("�μ� ��ȣ"));
		pnlSouth.add(new JTextField(5));
		
		
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new EmpFrame();
	}

}//class
