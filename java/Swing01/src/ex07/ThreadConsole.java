package ex07;

public class ThreadConsole extends Thread {

	@Override
	public void run() {
		super.run();
		int i = 0;
		while (true) { //for(10), main에 run 올리면 10번 하고 메인 거 실행
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
		//메인 스택에서 run 무한반복이 먼저 시작되고 run 뒤에 실행 안 되서 main 그대로 있어서 "~" 문구 안 나옴
		//run 메소드가 main 위에 올라온 상태
		th.start(); 
		//main 스택 안에서 th.start()[또다른 스택 생성] 하고 "main close" 나옴[메인 스택 안에 내용 다 해서 main 끝], 
		//run()은 또다른 스택, 스레드 스택에서 무한 반복 [run은 Thread 메소드라서 start() 하면 저절로 실행됨]
		//Thread 스택 새로 생성, main하고 다른 스택
		System.out.println("main close");
	}

}//class
