package exchange.money;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.StringValueExp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ExchangeMoney extends JFrame{
	
	Container c = getContentPane();
	JPanel pnlNotrh = new JPanel();
	JPanel pnlCenter = new JPanel();
//	JLabel lblChangeMoney = new JLabel("거스름돈"); 
	//처음에 setUI()에서만 필요하니까 setUI()에서 바로 해도 됨 굳이 필드로 만들어서 다음에 사용 안 함!!!
	JTextField txtMoney = new JTextField(10);
	JButton btnCalculate = new JButton("계산");
	JButton btnSend = new JButton("송금");
	
//	int[] units = new int[]{5000, 1000, 500, 100, 50, 10 ,1};
	
	JLabel lbl5000 = new JLabel("5000");
	JLabel lbl1000 = new JLabel("1000");
	JLabel lbl500 = new JLabel("500");
	JLabel lbl100 = new JLabel("100");
	JLabel lbl50 = new JLabel("50");
	JLabel lbl10 = new JLabel("10");
	JLabel lbl1 = new JLabel("1");
	JTextField txt5000 = new JTextField(6);
	JTextField txt1000 = new JTextField(6);
	JTextField txt500 = new JTextField(6);
	JTextField txt100 = new JTextField(6);
	JTextField txt50 = new JTextField(6);
	JTextField txt10 = new JTextField(6);
	JTextField txt1 = new JTextField(6);
	
	Calculator calcul = Calculator.getInctance();
	
	public ExchangeMoney() {
		setTitle("Exchange Money");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setListener();
		setSize(400, 400);
		setVisible(true);
	}
	
	private void setUI() {
		pnlNotrh.add(new JLabel("거스름돈"));
		pnlNotrh.add(txtMoney);
		pnlNotrh.add(btnCalculate);
		pnlNotrh.add(btnSend);
		pnlNotrh.setBackground(Color.cyan);
		c.add(pnlNotrh, new BorderLayout().NORTH);
		
//		pnlCenter.setLayout(new GridLayout(7,2));
//		for (int i=0; i<units.length; i++) {
//			pnlCenter.add(new JLabel())
//		}
		
		GridLayout grid = new GridLayout(7, 2);
		grid.setVgap(10);
		pnlCenter.setLayout(grid);
		
		pnlCenter.add(lbl5000);
		pnlCenter.add(txt5000);
		pnlCenter.add(lbl1000);
		pnlCenter.add(txt1000);
		pnlCenter.add(lbl500);
		pnlCenter.add(txt500);
		pnlCenter.add(lbl100);
		pnlCenter.add(txt100);
		pnlCenter.add(lbl50);
		pnlCenter.add(txt50);
		pnlCenter.add(lbl10);
		pnlCenter.add(txt10);
		pnlCenter.add(lbl1);
		pnlCenter.add(txt1);
		
//		txt1.setfont("맑은 고딕", Font.BOLD, 13);
		
//		pnlCenter.setLayout(new GridBagLayout());
		pnlCenter.setBackground(Color.yellow);
		c.add(pnlCenter, new BorderLayout().CENTER);
	}
	
	private void setListener() {
		btnCalculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("check!!!!!");
				int money = Integer.parseInt(txtMoney.getText());
			
				int[] changeCount = calcul.calculate(money);
				
				System.out.println(changeCount); //배열 주소값 나옴
				
				txt5000.setText(""+changeCount[0]);
				txt1000.setText(""+changeCount[1]);
				txt500.setText(""+changeCount[2]);
				txt100.setText(""+changeCount[3]);
				
				txt1.setText(String.valueOf(changeCount[4]));
				txt1.setText(String.valueOf(changeCount[5]));
				txt1.setText(String.valueOf(changeCount[6]));
				//String.valueOf()으로 int를 String으로 형변환
				
			}//actionPerformed
		});//ActionListener()
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountDao dao = AccountDao.getInstance();
				dao.sendMoney(10);
			}
		});
	}

	public static void main(String[] args) {
		new ExchangeMoney();
	}

}//class
