package tv.ex03;

public class TvMain {

	public static void main(String[] args) {
		Tv tv1=new Tv();
		tv1.power();
		
		System.out.println("-------------------------");
		
		for (int i=1; i<=20; i++) { 
			tv1.channelUp();
		}
		System.out.println("-------------------------");
		
		for (int i=1; i<=20; i++) { 
			tv1.channelDown();
		}
		System.out.println("-------------------------");
		
		tv1.volumeUp();
		tv1.volumeUp();
		tv1.volumeUp();
//		tv1.volume=2000000;
		System.out.println("-------------------------");
		
		tv1.volumeDown();
		System.out.println("-------------------------");
		
		tv1.mute();
		tv1.mute();
		tv1.volumeUp();
		System.out.println("-------------------------");
		tv1.mute();
		tv1.mute();
		System.out.println("-------------------------");
		
		tv1.power();
	}
}
