package abstrac.ex02;

public class Marine extends Unit {

	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.printf("걸어서 %d, %d로 이동\n", x, y);
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}

}
