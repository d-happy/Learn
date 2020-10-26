package abstrac.ex02;

public class DropShip extends Unit {
	
	Unit[] units=new Unit[4];
	int index=0;

	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		
		for (Unit u : units) {
			if (u==null) {
				break;
			}
			u.x=x;
			u.y=y;
		}
		System.out.printf("���Ƽ� %d, %d�� �̵�\n", x, y);
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}
	
	void load(Unit u) {
		if (index>=4) {
			System.out.println("�����Դϴ�.");
			return;
		}
		units[index]=u;
		index++;
	}

}
