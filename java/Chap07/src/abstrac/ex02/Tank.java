package abstrac.ex02;

public class Tank extends Unit {

	
	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.printf("������ %d, %d�� �̵�\n", x, y);
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}


}
