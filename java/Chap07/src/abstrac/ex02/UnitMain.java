package abstrac.ex02;

public class UnitMain {

	public static void main(String[] args) {
		DropShip dship=new DropShip();
		for (int i=0; i<4; i++) {
			if (i%2==0) {
				dship.load(new Marine());
			} else {
				dship.load(new Tank());
			}
		}
//		dship.load(new Unit); //추상 클래스는 객체 생성 안됨
		
		//향상된 for문 (enhanced for), 고속 열거문
		//일반 for 문보다 속도 빠름
		//가져오기만 가능
		//for (int i=0; i<dship.length; i++) {
		//    System.out.println(dship.units[i]); }
		
		for (Unit u : dship.units) {
			System.out.println(u);
		}
		
		dship.move(10,10);
		System.out.printf("DropShip: [%d, %d]\n", 
				dship.x, dship.y);
		
		for (Unit u : dship.units) {
			if (u==null) {
				break;
			}
			System.out.printf("Unit: [%d, %d]\n", u.x, u.y);
		}
		
//		Unit u=new Unit(); //x

	}//main

}//class
