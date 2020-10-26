package tv.ex01;

public class TvMain {

	public static void main(String[] args) {
		Tv tv1=new Tv();
		tv1.power();
		tv1.channelUp();
		tv1.channelDown();

		tv1.volumeUp();
		tv1.volumeUp();
		tv1.volumeUp();
		
		for (int i=1; i<=200; i++) {
			tv1.volumeDown();
		}
		tv1.power();

	}
}
