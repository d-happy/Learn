package ex07;

public class ThreadConsole extends Thread {

	@Override
	public void run() {
		super.run();
		int i = 0;
		while (true) { //for(10), main�� run �ø��� 10�� �ϰ� ���� �� ����
			try {
				Thread.sleep(1000);
				System.out.println(++i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadConsole th = new ThreadConsole();
//		th.run();
		//���� ���ÿ��� run ���ѹݺ��� ���� ���۵ǰ� run �ڿ� ���� �� �Ǽ� main �״�� �־ "~" ���� �� ����
		//run �޼ҵ尡 main ���� �ö�� ����
		th.start(); 
		//main ���� �ȿ��� th.start()[�Ǵٸ� ���� ����] �ϰ� "main close" ����[���� ���� �ȿ� ���� �� �ؼ� main ��], 
		//run()�� �Ǵٸ� ����, ������ ���ÿ��� ���� �ݺ� [run�� Thread �޼ҵ�� start() �ϸ� ������ �����]
		//Thread ���� ���� ����, main�ϰ� �ٸ� ����
		System.out.println("main close");
	}

}//class
