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
	JButton btnAll = new JButton("전체조회");
	JLabel lblSearch = new JLabel("검색:");
	JButton btnSearch = new JButton("검색");
	JButton btnDelete = new JButton("삭제");
	JButton btnInput = new JButton("추가");
	JTextField txtSearch = new JTextField(10);
	JTextArea txtResult = new JTextArea();
	EmpDao dao = EmpDao.getInstance();
	
//	int[] inputData = new int[]{0,1,2,3,4,5,6,7};
	
	public EmpFrame() {
		setTitle("사원 정보 보기 예제");
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
				//txtSearch에 입력한 값  String 변수로 저장
				List<EmpVO> list = dao.searchEname(name); 
				//searchEname한 결과 리스트로 저장
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
				} //하나하나 EmpVO, 리스트 안의 구성물인 vo에서 get해서 출력함
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
		pnlSouth.add(new JLabel("사원 번호"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("사원 이름"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("직급"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("상사 사원번호"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("입사 날짜"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("월급"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("커미션"));
		pnlSouth.add(new JTextField(5));
		pnlSouth.add(new JLabel("부서 번호"));
		pnlSouth.add(new JTextField(5));
		
		
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new EmpFrame();
	}

}//class
