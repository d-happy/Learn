package abstrac.ex01;

public class BirdMain {

	public static void main(String[] args) {
		Bird[] birds= {
				new Eagle(),
				new BlackBird()
		};
		for (int i=0; i<birds.length; i++) {
			birds[i].sing();
		}
		//추상 클래스는 객체 생성 X
//		Bird b=new Bird(); //Cannot instantiate the type Bird

	}//main

}//class
