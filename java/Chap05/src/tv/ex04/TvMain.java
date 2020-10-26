package tv.ex04;

public class TvMain {

	public static void main(String[] args) {
		Tv tv1=new Tv();
		
		tv1.setVolume(10);
		int vol=tv1.getVolume();
		System.out.println(vol);
		
		tv1.setChannel(12);
		int ch=tv1.getChannel();
		System.out.println(ch);
		
		
		
	}
	
} //class
